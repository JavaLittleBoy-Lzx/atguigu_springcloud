package com.lzx.springcloud.controller;

import com.lzx.springcloud.entities.CommonResult;
import com.lzx.springcloud.entities.Payment;
import com.lzx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
}
