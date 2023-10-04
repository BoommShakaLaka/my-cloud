package com.cloud.filter;

import com.cloud.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    private final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Autowired
    private LogService logService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求信息
        String method = exchange.getRequest().getMethod().name();
        String path = exchange.getRequest().getPath().value();
        String query = exchange.getRequest().getQueryParams().toString();

        // 处理请求日志
        logService.logRequest(method, path, query);

        // 继续执行下一个过滤器
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            // 获取响应信息
            HttpStatus statusCode = exchange.getResponse().getStatusCode();
            HttpHeaders headers = exchange.getResponse().getHeaders();

            // 处理响应日志
            logService.logResponse(statusCode, headers);
        }));
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
