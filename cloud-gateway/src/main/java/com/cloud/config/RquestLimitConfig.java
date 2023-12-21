package com.cloud.config;

import com.cloud.filter.ratelimit.UrlKeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RquestLimitConfig {
    @Bean
    public KeyResolver urlKeyResolver() {
        return new UrlKeyResolver();
    }
}
