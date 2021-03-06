package com.eurekafeign.controller;

import com.eurekafeign.service.ScheduaServiceHi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangding
 * @create 2018/6/12 20:29
 * @desc
 **/
@RestController
public class HiController {
    @Autowired
    private ScheduaServiceHi scheduaServiceHi;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return scheduaServiceHi.sayHiFromClientOne(name);
    }
}