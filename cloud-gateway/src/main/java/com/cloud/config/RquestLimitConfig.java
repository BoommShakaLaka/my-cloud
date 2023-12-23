package com.cloud.config;

import com.cloud.filter.ratelimit.CustomRedisRateLimiter;
import com.cloud.filter.ratelimit.UrlKeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RquestLimitConfig {
    @Bean
    @Primary
    public KeyResolver urlKeyResolver() {
        return new UrlKeyResolver();
    }

    @Bean
    @Primary
    public CustomRedisRateLimiter customRedisRateLimiter() {
        return new CustomRedisRateLimiter(10, 20);
    }

}
