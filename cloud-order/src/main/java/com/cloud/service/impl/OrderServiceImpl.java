package com.cloud.service.impl;

import com.cloud.entity.Order;
import com.cloud.mapper.OrderMapper;
import com.cloud.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order queryOrderById(Long orderId) {
        return orderMapper.queryOrderById(orderId);
    }
}
