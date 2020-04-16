package com.shefzee.order.service;

import com.shefzee.order.domain.Order;
import com.shefzee.order.domain.Payment;
import com.shefzee.order.repository.OrderRepository;
import com.shefzee.order.request.TransactionRequest;
import com.shefzee.order.response.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.UUID;

@Service
@RefreshScope
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    @Override
    public TransactionResponse save(TransactionRequest request) {

        Order order= request.getOrder();
        order.setId(UUID.randomUUID().toString());

        Payment payment = request.getPayment();
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setOrderId(order.getId());
        payment.setStatus(getPaymentStatus());

        if(payment.getStatus().equals("success")) {

            restTemplate.postForObject(ENDPOINT_URL, payment, Payment.class);
            order = orderRepository.save(request.getOrder());
        }
        String message = payment.getStatus().equals("success")?"Payment success":"Error in payment,order not placed";
        return TransactionResponse.builder()
                .order(order)
                .transactionId(payment.getTransactionId())
                .message(message)
                .build();
    }

    private String getPaymentStatus(){
        return new Random().nextBoolean()?"success":"failed";
    }
}
