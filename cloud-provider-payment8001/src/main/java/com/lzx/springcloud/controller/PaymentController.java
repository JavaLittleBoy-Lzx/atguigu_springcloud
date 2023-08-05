package com.lzx.springcloud.controller;

import com.lzx.springcloud.entities.CommonResult;
import com.lzx.springcloud.entities.Payment;
import com.lzx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author lzx
 * @Date 2023/8/2 16:23:16
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {
    // 注入service
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int res = paymentService.create(payment);
        log.info("------------开始插入数据--------------");
        if (res > 0) {
            return new CommonResult(200,"插入数据成功！\\t 服务端口：" +serverPort,res);
        }else {
            return new CommonResult(444,"插入数据库失败！",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPayment(id);
        if (payment != null) {
            return new CommonResult(200,"查询数据成功！\\t 服务端口：" + serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败！",null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service = " + service);
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" +instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
