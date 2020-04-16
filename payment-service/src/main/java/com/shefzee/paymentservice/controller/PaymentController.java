package com.shefzee.paymentservice.controller;

import com.shefzee.paymentservice.domain.Payment;
import com.shefzee.paymentservice.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    PaymentServiceImpl paymentService;

    @PostMapping("/do-payment")
    public Payment doPayment(@RequestBody Payment payment){

        return paymentService.save(payment);
    }

    @GetMapping("/history")
    public List<Payment> getAll(){
        return paymentService.getAll();
    }
}
