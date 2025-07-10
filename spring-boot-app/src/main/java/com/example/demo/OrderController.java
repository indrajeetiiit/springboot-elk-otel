package com.example.demo.controller;

import com.example.demo.model.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping
    public String createOrder(@RequestBody OrderRequest orderRequest) {
        logger.info("Received new order: ID={}, Product={}, Quantity={}",
                orderRequest.getOrderId(),
                orderRequest.getProduct(),
                orderRequest.getQuantity());

        return "Order created successfully!";
    }
}
