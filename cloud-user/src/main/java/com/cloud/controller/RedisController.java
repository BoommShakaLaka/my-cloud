package com.cloud.controller;

import com.cloud.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RedisController {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/redis")
    public void fun1() {
        redisTemplate.opsForValue().set("stringKey1", "你好");
        redisTemplate.opsForValue().set("stringKey2", "xxxx");
        System.out.println(redisTemplate.opsForValue().get("stringKey1"));
        redisTemplate.opsForValue().set("stringKey3", new User(1, "贾宝玉", "宝玉"));

        redisTemplate.opsForHash().put("hashKey1", "key1", "valu1");
        redisTemplate.opsForHash().put("hashKey1", "key2", "valu2");
        redisTemplate.opsForHash().put("hashKey1", "key3", new User(1, "贾宝玉", "宝玉"));
        System.out.println(redisTemplate.opsForHash().get("hashKey1", "key1"));


        redisTemplate.opsForList().leftPush("listKey1", "value1");
        redisTemplate.opsForList().leftPush("listKey1", "value2");
        redisTemplate.opsForList().leftPush("listKey1", "value3");
        redisTemplate.opsForList().leftPush("listKey1", new User(1, "贾宝玉", "宝玉"));

        redisTemplate.opsForSet().add("setKey", "value4", "value5", "value1", "value2", "value3");
        redisTemplate.opsForSet().add("setKey", "value4");

        redisTemplate.opsForZSet().add("zsetKey1", "value1", 1);
        redisTemplate.opsForZSet().add("zsetKey1", "value2", 2);
        redisTemplate.opsForZSet().add("zsetKey1", "value3", 0);

        String script = "redis.call('set', KEYS[1], ARGV[1]); redis.call('set', KEYS[2], ARGV[2])";
        DefaultRedisScript<Void> redisScript = new DefaultRedisScript<>(script, Void.class);
        List<String> keys = Arrays.asList("key1", "key2");
        List<String> args = Arrays.asList("value1", "value2");
        redisTemplate.execute(redisScript, keys, args.toArray());


    }
}
