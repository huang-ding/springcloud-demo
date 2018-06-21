package com.eurekafeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huangding
 * @create 2018/6/12 20:26
 * @desc
 **/
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
@Service
public interface ScheduaServiceHi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}