package com.xufan.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xufan.domain.User;
import com.xufan.mapper.UserMapper;
import com.xufan.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XuFan
 * @create 2023-08-07-14:12
 */
@RestController
@RequiredArgsConstructor()
@RequestMapping("/table")
public class TableController {
    @Autowired
    private UserMapper userMapper;
    @PostMapping("/getTableData")
    public CommonResult<Object> getTableDta(){
        List<User> tableData = userMapper.getAllUser();
        return CommonResult.success(tableData);
    }
}
