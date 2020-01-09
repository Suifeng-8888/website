package com.qh.hwebsite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qh.hwebsite.*.mapper")
public class HwebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(HwebsiteApplication.class, args);
    }

}
