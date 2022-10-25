package com.cloud.controller;

import com.cloud.entity.User;
import com.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    private UserService userService;


    @GetMapping("/user")
    public User getUser() {
        User user = new User();
        user.setName("贾宝玉");
        user.setAddress("怡红院");
        log.info("人员信息：{}",user);
        return user;
    }
    @GetMapping("/thread")
    public void testThread(){
        userService.testThread();
    }
}
