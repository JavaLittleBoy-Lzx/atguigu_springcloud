package com.lzx.springcloud.dao;

import com.lzx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDAO {
    //插入数据
    int create(Payment payment);
    //读取数据
    Payment getPayment(@Param("id") Long id);
}
