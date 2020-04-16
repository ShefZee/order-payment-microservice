package com.shefzee.cloudgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/orderFallBack")
    public String orderFallback(){
        return "Order service is taking too much time to respond";
    }

    @RequestMapping("/paymentFallback")
    public String paymentFallback(){
        return "Payment service is taking too much time to respond";
    }
}
