package com.cloud.controller;

import com.cloud.entity.Order;
import com.cloud.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;
    @Mock
    private OrderService orderService;

    @Test
    public void queryOrderByIdTest() {
        Long orderId = 10000001L;
        Order order = new Order();
        order.setOrderNo(11111);
        order.setAmount(2);
        order.setGoods("五粮液");
        given(orderService.queryOrderById(orderId)).willReturn(order);
        Order result = orderController.queryOrderById(10000001L);
        then(result.getOrderNo()).isEqualTo(12);
    }
}
