package com.cloud.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class OrderConfig {
    @Autowired
    private static Properties properties;

    public static Properties properties() {
        return properties;
    }

    public OrderConfig(Properties properties) {
        OrderConfig.properties = properties;
    }

    @Data
    @Component
    @ConfigurationProperties(prefix = "order")
    public static class Properties {
        private boolean querySwitch = true;
    }



}
