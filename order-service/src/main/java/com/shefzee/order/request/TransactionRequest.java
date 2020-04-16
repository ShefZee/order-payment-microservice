package com.shefzee.order.request;

import com.shefzee.order.domain.Order;
import com.shefzee.order.domain.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TransactionRequest {

    private Order order;
    private Payment payment;
}
