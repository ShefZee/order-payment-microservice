package com.shefzee.paymentservice.service;

import com.shefzee.paymentservice.domain.Payment;
import com.shefzee.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment save(Payment payment){
        return paymentRepository.save(payment);
    }

    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }
}
