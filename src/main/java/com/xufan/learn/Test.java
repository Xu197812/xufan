package com.xufan.learn;

import com.xufan.domain.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author XuFan
 * @create 2023-02-24-15:18
 */

public class Test {
    public static String dateParse(String startDate) throws ParseException {
        startDate = "2023-01-01";
        startDate = "2023-04-22 11:59:59";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(startDate);
        System.out.println(date.getTime());
        return String.valueOf(date.getTime());
    }

    public void test2() {
        List<User> list = new ArrayList<>();

        //定义三个用户对象
        User user1 = new User();
        user1.setUserName("admin");
        user1.setAge(16);
        user1.setSex("男");

        User user2 = new User();
        user2.setUserName("root");
        user2.setAge(20);
        user2.setSex("女");

        User user3 = new User();
        user3.setUserName("admin");
        user3.setAge(18);
        user3.setSex("男");

        User user4 = new User();
        user4.setUserName("admin11");
        user4.setAge(22);
        user4.setSex("女");

        //添加用户到集合中
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        /*
        在集合中查询用户名包含admin的集合
        */
        List<User> userList = list.stream().filter(user -> user.getUserName().contains("admin")
                && user.getAge() <= 20).collect(Collectors.toList());
        System.out.println(userList);

    }

    public static void main(String[] args) {
//        List<String> strings = Arrays.asList("abc", "qwe", "asd", "zxc", "qaz", "", "wsx", "edc", "", "rfv");
//        List<String> filtered = strings.stream().filter(temp -> !temp.isEmpty()).collect(Collectors.toList());
//        System.out.println(filtered);

//        List<String> strings2 = Arrays.asList("abc", "qwe", "asd", "zxc", "qaz", "", "wsx", "edc", "", "rfv");
//        List<String> maped = strings2.stream().filter(str -> !str.isEmpty()).map(str -> str + "IT").collect(Collectors.toList());
//        System.out.println(maped);

//        String   strTest= "helloWord";
//        System.out.println(strTest.startsWith("hello"));//输出true
//        System.out.println(strTest.startsWith("helloY"));//输出false
//        System.out.println(strTest.startsWith("ello",1));//输出false

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        map1.put("name", "xufan");
        map2.put("name", "xufan");
        map3.put("name", "xufan");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        List<Map<String, Object>> newMap = list.stream().map(temp -> {
            System.out.println(temp);
            Map<String, Object> temp1 = new HashMap<>();
            temp1.put("name", temp.get("name") + "123123");
            return temp1;
        }).collect(Collectors.toList());
        System.out.println(newMap);



    }

}
