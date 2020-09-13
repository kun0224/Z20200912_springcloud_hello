package com.lianxi.springcloud.controller;

import com.lianxi.springcloud.entities.CommonResult;
import com.lianxi.springcloud.entities.Payment;
import com.lianxi.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    /**
     * 插入
     *
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        System.out.println(payment);
        try {
            int i = paymentService.create(payment);
            System.out.println(i);
            if (i == 0) {
                CommonResult<Payment> result = new CommonResult<Payment>();
                result.setCode(444);
                result.setMessage("添加数据失败");
                result.setData(null);
                log.debug("");
                return result;
            } else {
                CommonResult<Payment> result = new CommonResult<Payment>();
                result.setCode(222);
                result.setMessage("添加数据成功");
                result.setData(payment);
                log.debug("");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            CommonResult<Payment> result = new CommonResult<Payment>();
            result.setCode(555);
            result.setMessage("添加数据异常" + e.getMessage());
            result.setData(null);
            log.debug("");
            return result;
        }
    }

    /**
     * 查询
     *
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        CommonResult<Payment> result = new CommonResult<Payment>();
        result.setCode(666);
        result.setMessage("查询成功");
        result.setData(paymentById);
        log.debug("");
        return result;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
