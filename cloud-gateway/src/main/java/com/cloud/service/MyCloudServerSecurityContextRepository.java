package com.cloud.service;

import com.cloud.entity.MyCloudAuthenticationToken;
import com.cloud.entity.MyCloudCredentials;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Repository
public class MyCloudServerSecurityContextRepository implements ServerSecurityContextRepository {

    @Resource
    MyCloudReactiveAuthenticationManager myCloudReactiveAuthenticationManager;

    @Override
    public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {
        return Mono.empty();
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange exchange) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        return myCloudReactiveAuthenticationManager
                .authenticate(
                        new MyCloudAuthenticationToken(null,
                                new MyCloudCredentials(headers.getFirst("Authorization"))
                        ))
                .map(SecurityContextImpl::new);
    }
}
