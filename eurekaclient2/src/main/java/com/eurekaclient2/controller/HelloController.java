package com.eurekaclient2.controller;

import com.eurekaclient2.servcie.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangding
 * @create 2018/6/12 19:42
 * @desc
 **/
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}