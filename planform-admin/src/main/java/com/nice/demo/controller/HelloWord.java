package com.nice.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springbootTest
 * @description: 测试
 * @author: lifuye
 * @create: 2018-09-06 18:26
 **/
@RestController
@RequestMapping("/HelloWord")
public class HelloWord {

    @GetMapping("/hello")
    public String hell(){
        return "hello";
    }
}
