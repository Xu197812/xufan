package com.xufan.learn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author XuFan
 * @create 2023-05-05-10:08
 */
public class Test2 {

    public static void main(String[] args) {
        String temp = "[\"MB One Web-Model D\",\"WeCom-Model D\"]";
        List<String> a = JSON.parseArray(temp, String.class);
        System.out.println(a);
    }
}
