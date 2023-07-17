package com.cloud.controller;

import com.cloud.entity.Order;
import com.cloud.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * mock对象，不会调用真实库、不加载上下文，单元测试
 */
public class OrderControllerTest3 {

    @Mock
    private OrderService orderService; //模拟对象

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // 初始化模拟对象和被测试对象
    }


    @Test
    public void queryOrderByIdTest() {
        Order order = new Order();
        order.setOrderNo(11111);
        order.setAmount(2);
        order.setGoods("五粮液");
        Order order1 = new Order();
        order1.setOrderNo(11111);
        order1.setAmount(2);
        order1.setGoods("五粮液");
        when(orderService.queryOrderById(Mockito.anyLong())).thenReturn(order);
        Assertions.assertEquals(order1,orderController.queryOrderById(Mockito.anyLong()));
    }
}
