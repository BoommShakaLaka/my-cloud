package com.cloud.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Optional;

@EnableSchedulerLock(defaultLockAtMostFor = "60s", defaultLockAtLeastFor = "1s")
@EnableScheduling
@Configuration
public class ScheduleConfig {
    @Bean
    public LockProvider lockProvider(RedisConnectionFactory redisConnectionFactory) {
        return Optional.ofNullable(redisConnectionFactory)
                .map(RedisLockProvider::new).orElseThrow(NullPointerException::new);
    }
}
