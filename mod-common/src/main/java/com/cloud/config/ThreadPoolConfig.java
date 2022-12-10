package com.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean(name = "baseThreadPool")
    public ThreadPoolTaskExecutor buildThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CommonConfig.properties().getThreadPool().getCorePoolSize());
        executor.setMaxPoolSize(CommonConfig.properties().getThreadPool().getMaxPoolSize());
        executor.setQueueCapacity(CommonConfig.properties().getThreadPool().getQueueCapacity());
        executor.setKeepAliveSeconds(CommonConfig.properties().getThreadPool().getKeepAliveSeconds());
        executor.setThreadNamePrefix(CommonConfig.properties().getThreadPool().getThreadNamePrefix());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
