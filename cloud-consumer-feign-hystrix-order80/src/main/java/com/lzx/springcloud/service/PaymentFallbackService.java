package com.lzx.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentFallbackService
 * @Description TODO
 * @Author lzx
 * @Date 2023/8/4 11:18:57
 * @Version 1.0
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "--------PaymentFallbackService fall back-paymentInfo_OK,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--------PaymentFallbackService fall back-paymentInfo_TimeOut,/(ㄒoㄒ)/~~";
    }
}
