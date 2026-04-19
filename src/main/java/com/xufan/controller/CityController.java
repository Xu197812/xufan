package com.xufan.controller;


import com.alibaba.fastjson.JSON;
import com.xufan.domain.City;
import com.xufan.mapper.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xufan
 * @since 2023-06-14
 */
@RestController
@RequiredArgsConstructor()
@RequestMapping("/city")
public class CityController {

    public final CityMapper cityMapper;


}
