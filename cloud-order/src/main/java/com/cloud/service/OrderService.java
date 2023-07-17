package com.cloud.service;

import com.cloud.entity.Order;
import com.cloud.exception.MyCloudException;

public interface OrderService {
    Order queryOrderById(Long orderId);
}
