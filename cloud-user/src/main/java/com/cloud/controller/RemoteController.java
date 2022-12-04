package com.cloud.controller;

import org.apache.http.client.HttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class RemoteController {
    @Resource
    RestTemplate restTemplate;
    @Resource
    HttpClient httpClient;

    @GetMapping("/restTempate")
    public void fun1() {

    }
}
