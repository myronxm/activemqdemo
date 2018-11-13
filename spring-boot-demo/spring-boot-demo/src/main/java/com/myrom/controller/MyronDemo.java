package com.myrom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * myron-spring-boot-demo
 *
 * @author mijp
 * @date 2018/5/11 18:06
 */
@RestController
public class MyronDemo {

    @RequestMapping("/myron")
    public String sayMyron() throws Exception {
        throw new NullPointerException("asd");
}

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello, myron!";
    }
}
