package com.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomcatProcessingRequestsController {
    @GetMapping("tomcat")
    public String tomcatRequest() {
        System.out.println(Thread.currentThread().getName() + " 线程进入");
        return "success";
    }
}
