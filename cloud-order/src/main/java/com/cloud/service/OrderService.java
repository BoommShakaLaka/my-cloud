package com.cloud.service;

import com.cloud.entity.Order;

public interface OrderService {
    Order queryOrderById(Long orderId);
}
