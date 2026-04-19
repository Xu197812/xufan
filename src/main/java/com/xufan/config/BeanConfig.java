package com.xufan.config;

import com.xufan.learn.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XuFan
 * @create 2023-05-05-10:02
 */
@Configuration
public class BeanConfig {


    @Bean
    public Test test() {
        return new Test();
    }




}
