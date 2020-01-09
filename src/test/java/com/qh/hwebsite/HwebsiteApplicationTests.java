package com.qh.hwebsite;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class HwebsiteApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        String str="abc|bcd";
        int num = str.indexOf("|");
        String s1 = str.substring(0,num);
        String s2 = str.substring(num+1);
        System.out.println(s1);
        System.out.println(str);
        System.out.println(s2);
    }
}
