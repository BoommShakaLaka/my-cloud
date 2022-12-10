package com.cloud.controller;

import com.cloud.config.CommonConfig;
import com.cloud.entity.User;
import com.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RefreshScope //有此注解，@value注解会实时生效
public class UserController {
    @Value("${common.urls.url1}")
    private String url;

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public User getUser() {
        return userService.queryUserById(1);
    }

    @GetMapping("/user/{name}")
    public User queryUserByName(@PathVariable("name") String name) {
        return userService.queryUserByName(name);
    }

    @GetMapping("/thread")
    public void testThread() {
        System.out.println(CommonConfig.properties().getThreadPool().getCorePoolSize());
        for (int i = 0; i < 100; i++) {
            userService.testThread();
        }
    }

    @GetMapping("/config")
    public void testConfig() {
        System.out.println(url);
    }




}
