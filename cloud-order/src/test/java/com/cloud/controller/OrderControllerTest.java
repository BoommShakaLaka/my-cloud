package com.cloud.controller;

import com.cloud.entity.Order;
import com.cloud.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
//mock对象，不会调用真实库、不加载上下文，单元测试
//在JUnit 5中，不再需要使用 @ExtendWith 注解来启用扩展。
//JUnit 5引入了一个新的测试引擎（JUnit Platform），它可以自动检测并加载扩展，包括Mockito扩展。
@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;  //被测试对象
    @Mock
    private OrderService orderService; //模拟对象

    @Test
    public void queryOrderByIdTest() {
        Long orderId = 10000001L;
        Order order = new Order();
        order.setOrderNo(11111);
        order.setAmount(2);
        order.setGoods("五粮液");
        given(orderService.queryOrderById(orderId)).willReturn(order);
        Order result = orderController.queryOrderById(10000001L);
        Assertions.assertEquals(11111,result.getOrderNo());
//        then(result.getOrderNo()).isEqualTo(11111);
    }
}
