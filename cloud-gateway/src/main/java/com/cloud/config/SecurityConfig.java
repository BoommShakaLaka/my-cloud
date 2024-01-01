package com.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain fluxSecurityWebFilterChain(ServerHttpSecurity http) {
        return http.formLogin().disable().build();
    }
}
