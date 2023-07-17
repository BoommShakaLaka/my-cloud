package com.cloud.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/*
MockMvc是Spring MVC提供的一个用于模拟HTTP请求和验证响应的工具类。它可以在单元测试中模拟发起HTTP请求，而无需启动整个应用程序或连接到实际的网络。

MockMvc可以与Spring Boot的单元测试框架一起使用，方便进行控制器层面的单元测试。通过使用MockMvc，可以模拟用户的HTTP请求，并验证控制器的行为和返回结果。
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OrderControllerTest1 {
    MockMvc mockMvc;

    @Resource
    WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void queryOrderByIdTest() throws Exception {
        mockMvc.perform(get("/order").param("orderId", "100000001"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.orderNo", Matchers.is(100000001)));
    }
}
