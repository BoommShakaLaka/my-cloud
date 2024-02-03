package com.cloud.service;

import com.cloud.entity.MyCloudAuthenticationToken;
import com.cloud.entity.MyCloudCredentials;
import com.cloud.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class MyCloudReactiveAuthenticationManager implements ReactiveAuthenticationManager {
    @Resource
    AuthManager authManager;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        MyCloudCredentials myCloudCredentials = (MyCloudCredentials) authentication.getCredentials();

        // 解析token
        log.info("myCloudCredentials:{}", myCloudCredentials);
        return authManager.parseToken(myCloudCredentials.getToken())
                .map(this::createAuthentication)
                .switchIfEmpty(Mono.defer(() -> {
                    log.info("认证失败");
                    return Mono.empty();
                }))
                .doOnNext(auth -> auth.setCredentials(myCloudCredentials))
                .cast(Authentication.class);
    }

    private MyCloudAuthenticationToken createAuthentication(UserInfo userInfo) {
        List<GrantedAuthority> grantedAuthoritieList = new ArrayList<>();
        if (userInfo.getUserId() != null) {
            if (userInfo.getUserId() == 111111) {
                grantedAuthoritieList.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "ROLE_ADMIN";
                    }
                });
            } else {
                grantedAuthoritieList.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "ROLE_USER";
                    }
                });
            }
        }
        return new MyCloudAuthenticationToken(userInfo, null, grantedAuthoritieList);
    }
}
