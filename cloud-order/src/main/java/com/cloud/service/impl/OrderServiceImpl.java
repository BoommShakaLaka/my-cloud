package com.cloud.service.impl;

import com.cloud.config.OrderConfig;
import com.cloud.entity.Order;
import com.cloud.mapper.OrderMapper;
import com.cloud.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order queryOrderById(Long orderId) {

        if (!OrderConfig.properties().isQuerySwitch()){
            return null;
        }

        Order order = orderMapper.queryOrderById(orderId);
        if (ObjectUtils.isEmpty(order)) {
            return null;
        } else {
            return order;
        }
    }
}
