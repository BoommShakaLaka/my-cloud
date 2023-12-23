package com.cloud.controller;

import com.cloud.entity.Order;
import com.cloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/fallback")
    public String fallback() {
        return "order fallback";
    }

    @GetMapping("/info")
    public Order queryOrderById(@RequestParam("orderId") Long orderId) {
        return orderService.queryOrderById(orderId);
    }


    @GetMapping("")
    public Order queryOrderByName(@RequestParam("orderId") Long orderId) {
//        return orderService.queryOrderByN(orderId);
        return null;
    }
}
