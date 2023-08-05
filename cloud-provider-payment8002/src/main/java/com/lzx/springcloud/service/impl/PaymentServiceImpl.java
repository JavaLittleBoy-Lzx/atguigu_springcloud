package com.lzx.springcloud.service.impl;

import com.lzx.springcloud.dao.PaymentDAO;
import com.lzx.springcloud.entities.Payment;
import com.lzx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @Author lzx
 * @Date 2023/8/2 16:20:25
 * @Version 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    // 注入Mapper
    @Resource
    private PaymentDAO paymentDAO;
    @Override
    public int create(Payment payment) {
        return paymentDAO.create(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentDAO.getPayment(id);
    }
}
