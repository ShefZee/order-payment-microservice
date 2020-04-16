package com.shefzee.order.service;

import com.shefzee.order.domain.Order;
import com.shefzee.order.request.TransactionRequest;
import com.shefzee.order.response.TransactionResponse;

public interface OrderService {

    TransactionResponse save(TransactionRequest request);
}
