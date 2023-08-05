package com.lzx.springcloud.controller;

import com.lzx.springcloud.entities.CommonResult;
import com.lzx.springcloud.entities.Payment;
import com.lzx.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderFeignController
 * @Description TODO
 * @Author lzx
 * @Date 2023/8/3 16:59:45
 * @Version 1.0
 **/
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPayment(id);
    }
}
