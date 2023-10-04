package com.cloud.controller;

import com.cloud.config.CommonConfig;
import com.cloud.entity.Block;
import com.cloud.entity.User;
import com.cloud.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RefreshScope //有此注解，@value注解会实时生效
public class UserController {
    @Value("${common.urls.url1}")
    private String url;

    @Autowired
    private UserService userService;


    @GetMapping("/info")
    public User getUser() {
        log.info("UserController#getUser:{}", 1);
        User user = userService.queryUserById(1);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Block> list = objectMapper.readValue(user.getBlocks(), new TypeReference<List<Block>>() {
            });
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userService.queryUserById(1);
    }

    @GetMapping("/info/{name}")
    public User queryUserByName(@PathVariable("name") String name) {
        log.info("UserController#queryUserByName:{}", name);
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

    @GetMapping("/userInfo/{id}")
    public User getUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        return user;
    }
}
