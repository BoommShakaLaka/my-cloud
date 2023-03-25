//package com.cloud.redis;
//
//import com.cloud.pojo.User;
//import org.springframework.data.redis.core.RedisTemplate;
//import redis.clients.jedis.DefaultJedisClientConfig;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisClientConfig;
//
//import java.util.Set;
//
//public class RedisDemo1 {
//    public static void main(String[] args) {
//        JedisClientConfig jedisClientConfig = new DefaultJedisClientConfig()
//        Jedis jedis = new Jedis("124.71.6.172");
//
//// 设置键的生存时间，单位为秒
//        jedis.expire("key1", 60);
//
//
//        String value = jedis.get("key1");
//// 判断key1是否过期，如果过期则删除该键
//        if(jedis.ttl("key1") == -2){
//            jedis.del("key1");
//        }
//
//// 创建一个zset用于存储过期时间和对应的key
//        jedis.zadd("expireTimeSet", System.currentTimeMillis(), "key1");
//        jedis.zadd("expireTimeSet", System.currentTimeMillis() + 60*1000, "key2");
//        jedis.zadd("expireTimeSet", System.currentTimeMillis() + 120*1000, "key3");
//        jedis.zadd("expireTimeSet", System.currentTimeMillis() + 180*1000, "key4");
//
//// 创建一个hash用于存储key和对应的value
//        jedis.hset("hash", "key1", "value1");
//        jedis.hset("hash", "key2", "value2");
//        jedis.hset("hash", "key3", "value3");
//        jedis.hset("hash", "key4", "value4");
//
//// 获取当前时间戳
//        long now = System.currentTimeMillis();
//
//// 获取需要被删除的键
//        Set<String> expireKeys = jedis.zrangeByScore("expireTimeSet", 0, now);
//
//// 删除过期的键及其对应的值
//        if(expireKeys != null && !expireKeys.isEmpty()){
//            String[] keys = expireKeys.toArray(new String[expireKeys.size()]);
//            jedis.zrem("expireTimeSet", keys);
//            jedis.hdel("hash", keys);
//        }
//
//    }
//}
