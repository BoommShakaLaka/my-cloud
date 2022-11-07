package com.cloud.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class BaseConfig {

    @Value("${common.urls.url1}")
    private String url;
}
