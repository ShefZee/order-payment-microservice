package com.shefzee.order.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Integer id;
    private String status;
    private String transactionId;
    private double amount;
    private String orderId;
}
