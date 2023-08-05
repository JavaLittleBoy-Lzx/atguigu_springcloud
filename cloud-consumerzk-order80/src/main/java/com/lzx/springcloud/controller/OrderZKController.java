package com.lzx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderZKController
 * @Description TODO
 * @Author lzx
 * @Date 2023/8/3 15:13:45
 * @Version 1.0
 **/
@RestController
@Slf4j
public class OrderZKController {
    @Resource
    private RestTemplate restTemplate;
    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo() {
        String forObject = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return forObject;
    }
}
