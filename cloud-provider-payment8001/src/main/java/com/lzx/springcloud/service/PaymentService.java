package com.lzx.springcloud.service;

import com.lzx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    //插入数据
    int create(Payment payment);
    //读取数据
    Payment getPayment(@Param("id") Long id);
}
