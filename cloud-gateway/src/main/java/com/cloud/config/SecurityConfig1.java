package com.cloud.config;

import com.cloud.service.MyCloudServerSecurityContextRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

import javax.annotation.Resource;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig1 {
    @Resource
    MyCloudServerSecurityContextRepository myCloudServerSecurityContextRepository;


    @Bean
    public SecurityWebFilterChain fluxSecurityWebFilterChain(ServerHttpSecurity http) {
        return http
                .securityContextRepository(myCloudServerSecurityContextRepository)
                .authorizeExchange()
                .pathMatchers("/user/info","/user/userInfo/**","/user/mainThread").permitAll()
                .pathMatchers("/user/config").hasAuthority("ROLE_ADMIN")
                .anyExchange()
                .denyAll()
                .and()
                .build();
    }
}
