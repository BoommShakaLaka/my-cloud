package com.cloud.service.impl;

import com.cloud.entity.Order;
import com.cloud.exception.MyCloudException;
import com.cloud.mapper.OrderMapper;
import com.cloud.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Collections;

import static com.cloud.exception.ErrorCode.USER_ALREADY_EXISTS;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order queryOrderById(Long orderId) {
        Order order = orderMapper.queryOrderById(orderId);
        if (ObjectUtils.isEmpty(order)) {
            return null;
        } else {
            return order;
        }
    }
}
