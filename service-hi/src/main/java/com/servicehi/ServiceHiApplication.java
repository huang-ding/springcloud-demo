package com.servicehi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RestController
@Slf4j
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String callHome() {
        log.info("calling trace service-hi  ");
        return restTemplate.getForObject("http://127.0.0.1:8989/miya", String.class);
    }


    @RequestMapping("/info")
    public String info() {
        log.info("calling trace service-hi ");
        return "i'm service-hi";
    }

    /**
     * Span:基本工作单元，一次链路调用(可以是RPC，DB等没有特定的限制)创建一个span，通过一个64位ID标识它， span通过还有其他的数据，例如描述信息，时间戳，key-value对的(Annotation)tag信息，parent-id等,其中parent-id
     * ， 可以表示span调用链路来源，通俗的理解span就是一次请求信息
     */
    //AlwaysSampler 类，它会导出所有的span,不能缺少该类
    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
