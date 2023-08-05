package com.lzx.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author lzx
 * @Date 2023/8/3 14:52:50
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentZk() {
        return "springcloud with zookeeper :" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
