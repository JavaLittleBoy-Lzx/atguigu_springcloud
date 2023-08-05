package com.lzx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderConsulController
 * @Description TODO
 * @Author lzx
 * @Date 2023/8/3 15:57:13
 * @Version 1.0
 **/
@RestController
@Slf4j
public class OrderConsulController {
    private static final String PAYMENT_URL = "http://consul-provider-payment";
    //调用RestTemplate
    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo() {
        String forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
        return forObject;
    }
}
