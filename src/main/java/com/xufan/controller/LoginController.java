package com.xufan.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xufan.domain.User;
import com.xufan.mapper.UserMapper;
import com.xufan.service.Impl.RedisServiceImpl;
import com.xufan.service.LoginService;
import com.xufan.service.UserService;
import com.xufan.utils.CommonResult;
import com.xufan.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author XuFan
 * @create 2023-03-23-13:44
 */
@RequestMapping("login")
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisServiceImpl redisServiceImpl;

    @RequestMapping("testBoot")
    public String testBoot(){
        return "boot服务";
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo(String userName) {
        List<User> userInfo = userMapper.selectList(new QueryWrapper<User>().eq("user_name",userName));
        return JSON.toJSONString(userInfo.size()==0?"账户不存在":userInfo.get(0));
    }


    @RequestMapping("login")
    public CommonResult<Object> login(@RequestBody User userdto) {
        List<User> userInfo = userMapper.selectList(new QueryWrapper<User>().eq("user_name",userdto.getUserName()));
        User user = userInfo.get(0) == null ? new User() : userInfo.get(0);
        if (user.getPassWord().equals(userdto.getPassWord())) {
            String token = TokenUtil.getToken(user.getId());
            String tokenExpiresTime = TokenUtil.getTokenBody(token).get("exp").toString();
            redisServiceImpl.setString(token ,user.getId(), 30L, TimeUnit.MINUTES);
            Map<String, Object> tokenMap = new HashMap<>(16);
            tokenMap.put("token", token);
            tokenMap.put("tokenExpiresTime", tokenExpiresTime);
            tokenMap.put("userInfo", JSON.toJSONString(user));
            return CommonResult.success(tokenMap);
        }
        return CommonResult.failed("登录失败");
    }

    @RequestMapping("getRefreshToken")
    public CommonResult<Object> getRefreshToken(@RequestBody String token) {
        if (TokenUtil.tokenIsExpire(token)) {
            Map<String, Object> tokenBody = TokenUtil.getTokenBody(token);
            String userId = String.valueOf(tokenBody.get("msg"));
            List<User> userInfo = userMapper.selectList(new QueryWrapper<User>().eq("id",userId));
            User user = userInfo.get(0) == null ? new User() : userInfo.get(0);

            token = TokenUtil.getToken(user.getId());
            String tokenExpiresTime = TokenUtil.getTokenBody(token).get("exp").toString();
            redisServiceImpl.setString(token ,user.getId(), 30L, TimeUnit.MINUTES);
            Map<String, Object> tokenMap = new HashMap<>(16);
            tokenMap.put("token", token);
            tokenMap.put("tokenExpiresTime", tokenExpiresTime);
            tokenMap.put("userInfo", JSON.toJSONString(user));
            return CommonResult.success(tokenMap);
        }
        return CommonResult.failed();
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public CommonResult<Object> test(@RequestHeader("Authorization") String token) {
        System.out.println(token);
        return CommonResult.success(token);
    }


}
