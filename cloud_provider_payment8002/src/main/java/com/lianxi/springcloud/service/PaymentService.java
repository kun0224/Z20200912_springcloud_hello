package com.lianxi.springcloud.service;

import com.lianxi.springcloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment); //写

    public Payment getPaymentById(Long id);  //读取


}
