package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {


    @Autowired
    private CacheManager cacheManager;


    @GetMapping("cache/{cacheName}/{key}")
    public Object cache(@PathVariable String cacheName, @PathVariable Integer key) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null && cache.getNativeCache() instanceof com.github.benmanes.caffeine.cache.Cache) {
            com.github.benmanes.caffeine.cache.Cache<Object, Object> caffeineCache = (com.github.benmanes.caffeine.cache.Cache<Object, Object>) cache.getNativeCache();
            for (Map.Entry<Object, Object> entry : caffeineCache.asMap().entrySet()) {
                if (key.equals(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @GetMapping("allCache")
    public HashMap<Object, Object> cache() {
        HashMap<Object, Object> hashMap = new HashMap();
        for (String name : cacheManager.getCacheNames()) {
            Cache cache = cacheManager.getCache(name);
            if (cache != null && cache.getNativeCache() instanceof com.github.benmanes.caffeine.cache.Cache) {
                com.github.benmanes.caffeine.cache.Cache<Object, Object> caffeineCache = (com.github.benmanes.caffeine.cache.Cache<Object, Object>) cache.getNativeCache();
                for (Map.Entry<Object, Object> entry : caffeineCache.asMap().entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    hashMap.put(key, value);
                    System.out.println("cacheName: " + name + ", key: " + key + ", value: " + value);
                }
                System.out.println(cache.getNativeCache());
                System.out.println(cache.getName());
            }
        }
        return hashMap;
    }
}
