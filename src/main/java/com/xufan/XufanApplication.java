package com.xufan;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.xufan.mapper")
@SpringBootApplication
public class XufanApplication {

    public static void main(String[] args) {
        SpringApplication.run(XufanApplication.class, args);
    }

}
