package com.cloud.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/redis")
    public void fun1() {
        redisTemplate.opsForValue().set("aaa", "你好");
        redisTemplate.opsForValue().set("bbb", "xxxx");
        System.out.println(redisTemplate.opsForValue().get("aaa"));
//        redisTemplate.opsForValue().set("object", new User(1, "贾宝玉", "宝玉"));
    }
}
