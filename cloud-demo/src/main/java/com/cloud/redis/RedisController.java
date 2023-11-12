package com.cloud.redis;

import com.cloud.pojo.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RedisController {

    @Resource
    RedisTemplate<String, Object> redisTemplate;
    @Resource
    RedisScript<String> script;
    @GetMapping("/redis")
    public void fun1() {
        redisTemplate.opsForValue().set("aaa", "你好");
        redisTemplate.opsForValue().set("object", new User(1, "贾宝玉", "宝玉"));

        String script = "return tonumber(ARGV[1]) + tonumber(ARGV[2])";
        DefaultRedisScript<Integer> redisScript = new DefaultRedisScript<>(script, Integer.class);
        List<String> keys = new ArrayList<>(); // 脚本中用到的key列表
        List<Object> args = new ArrayList<>(); // 脚本中用到的参数列表
        args.add("value1");
        args.add("value2");
        Integer result = redisTemplate.execute(redisScript, keys, args.toArray());

    }

}
