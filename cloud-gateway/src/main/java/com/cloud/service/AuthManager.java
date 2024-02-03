package com.cloud.service;

import com.cloud.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class AuthManager {
    public Mono<UserInfo> parseToken(String token) {
        if ("token123".equals(token)) {
            return Mono.just(new UserInfo(111111, "user1"));
        } else if ("token456".equals(token)) {
            return Mono.just(new UserInfo(222222, "user2"));
        } else {
            // 返回null或者抛出异常都可以
            return Mono.empty();
        }
    }
}
