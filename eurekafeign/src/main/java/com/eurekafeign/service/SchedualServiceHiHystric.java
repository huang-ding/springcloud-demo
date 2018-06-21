package com.eurekafeign.service;

import org.springframework.stereotype.Component;

/**
 * @author huangding
 * @create 2018/6/13 13:51
 * @desc
 **/
@Component
public class SchedualServiceHiHystric implements ScheduaServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry," + name;
    }
}