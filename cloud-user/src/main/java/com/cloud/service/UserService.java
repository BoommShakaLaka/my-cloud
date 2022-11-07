package com.cloud.service;

import com.cloud.entity.User;
import com.cloud.mapper.UserMapper;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    @SneakyThrows
    @Async("baseThreadPool")
    public void testThread() {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
    }

    public User queryUserById(Integer userId) {
        return userMapper.queryUserById(userId);
    }
}
