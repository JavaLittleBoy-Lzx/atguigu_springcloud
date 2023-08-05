package com.lzx.springcloud.service;

import com.lzx.springcloud.entities.CommonResult;
import com.lzx.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentFallbackService
 * @Description TODO
 * @Author lzx
 * @Date 2023/8/3 16:51:41
 * @Version 1.0
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id);
}
