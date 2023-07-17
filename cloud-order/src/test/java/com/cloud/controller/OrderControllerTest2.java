package com.cloud.controller;

import com.cloud.OrderApplicaion;
import com.cloud.entity.Order;
import com.cloud.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
/*
在Spring Boot中，使用@SpringBootTest注解来指定要进行单元测试的Spring Boot应用。该注解可以加载整个Spring应用的上下文，并提供了多种配置选项。

如果想要指定具体的启动类来进行单元测试，可以在@SpringBootTest注解中指定该启动类的class，例如：

@SpringBootTest(classes = OrderApplication.class)
public class UnitTest {
    // ...
}
在上述示例中，使用@SpringBootTest注解，并通过classes参数指定OrderApplication.class作为启动类。这样，在进行单元测试时，会加载OrderApplication类所在的应用上下文。

需要注意的是，如果没有指定classes参数，默认情况下@SpringBootTest会尝试加载当前测试类所在的包及其子包中的所有Spring组件。因此，如果测试类和启动类在同一个包中，可以省略classes参数，直接使用@SpringBootTest注解。

另外，可以在@SpringBootTest注解中使用其他参数来进行更精确的配置，例如：

webEnvironment：指定启动的web环境，可以选择的值有RANDOM_PORT（随机端口）、DEFINED_PORT（指定端口）和MOCK（模拟环境）。
properties：指定要加载的配置文件，可以是一个数组，可以指定多个配置文件。
value：指定要加载的配置类，可以是一个数组，可以指定多个配置类。
通过合理配置@SpringBootTest注解，可以灵活地加载不同的环境和配置，进行单元测试。
 */
//@SpringBootTest(classes = OrderApplicaion.class)
@SpringBootTest
public class OrderControllerTest2 {


    @Resource
    private OrderController orderController;

    @Test
    public void testQueryOrderById() {
        Order order = orderController.queryOrderById(100000001l);
        Assertions.assertEquals("红酒", order.getGoods());
    }
}
