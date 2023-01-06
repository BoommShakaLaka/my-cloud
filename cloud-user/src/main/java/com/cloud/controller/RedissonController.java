package com.cloud.controller;


import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class RedissonController {

    @Resource
    RedissonClient redissonClient;

    @GetMapping("redisson")
    public void test1() {
        RLock lock = redissonClient.getLock("redisson_lock");
        try {
            lock.tryLock(100, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }

    }
}
