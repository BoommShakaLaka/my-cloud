package com.cloud.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.entity.User;
import com.cloud.mapper.UserMapper;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    @Async("mainThreadPool")
    public void testMainThread() {
        System.out.println(Thread.currentThread().getName());
    }

    public void testSecondThread() {
        System.out.println(Thread.currentThread().getName());
    }

    public User queryUserById(Integer userId) {
        return userMapper.queryUserById(userId);
    }


    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    public User getUserById(Integer id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        return userMapper.selectById(id);
    }
}
