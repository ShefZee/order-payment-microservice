package com.shefzee.order.controller;


import com.shefzee.order.domain.Order;
import com.shefzee.order.request.TransactionRequest;
import com.shefzee.order.response.TransactionResponse;
import com.shefzee.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/book-order")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){

        return orderService.save(request);

    }
}
