package com.cloud.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class CommonConfig {
    @Autowired
    private static Properties properties;

    public static Properties properties() {
        return properties;
    }

    public CommonConfig(Properties properties) {
        CommonConfig.properties = properties;
    }

    @Data
    @Component
    @ConfigurationProperties(prefix = "common")
    public static class Properties {
        private ThreadPool threadPool;
        private User user;
    }

    @Data
    public static class ThreadPool {
        private int corePoolSize;
        private int maxPoolSize;
        private int keepAliveSeconds;
        private int queueCapacity;
        private String threadNamePrefix;
    }

    @Data
    public static class User {
        private String name;
    }


}
