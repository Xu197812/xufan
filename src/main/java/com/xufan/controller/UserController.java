package com.xufan.controller;


import ch.qos.logback.core.joran.spi.NoAutoStart;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xufan.domain.City;
import com.xufan.domain.User;
import com.xufan.mapper.CityMapper;
import com.xufan.mapper.UserMapper;
import com.xufan.utils.CommonResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xufan
 * @since 2023-04-14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    CityMapper cityMapper;

    @RequestMapping("/test")
    public void test(){

        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");


        System.out.println(System.currentTimeMillis());
        String id = UUID.randomUUID().toString().replaceAll("-","");
        User user = new User();
        user.setId(id);
        userMapper.insert(user);

        System.out.println(System.currentTimeMillis());

        for (int i = 0; i < 1000; i++){
            String id2 = UUID.randomUUID().toString().replaceAll("-","");
            User user1 = new User();
            user.setId(id2);
            userMapper.insert(user1);
        }
        System.out.println(System.currentTimeMillis());
    }

    public void save() {
        userMapper.insert(new User());
    }

    @GetMapping("getMap")
    public CommonResult getMap(){

        List<Map<String, Object>> list = cityMapper.getMap();

        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> province = new HashSet<>();
        for (Map<String, Object> temp : list) {
            province.add(String.valueOf(temp.get("provice")));
        }

        for (String temp : province) {
            Map<String, Object> data = new HashMap<>();
            data.put("provice", temp);
            Set<String> city = new HashSet<>();

            for (Map<String, Object> map : list) {
                if (String.valueOf(map.get("provice")).equals(temp)){
                    city.add(String.valueOf(map.get("city")));
                }
            }
            data.put("city", city);
            result.add(data);
        }
        System.out.println(result);
        return CommonResult.success(result);
    }































}
