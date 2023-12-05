package com.abg.gateway.filter;

import com.abg.gateway.config.GatewayDataConfiguration;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/28/2023
 */
@Component
public class AuthorizationFilter extends AbstractGatewayFilterFactory<GatewayDataConfiguration> {
    @Override
    public GatewayFilter apply(GatewayDataConfiguration config) {
        return (exchange, chain) -> {
            //return Mono.empty();
            ServerHttpRequest request = exchange.getRequest();
            String authHeaderValue = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            System.out.println("Request path :" + request.getPath()+" Header :"+authHeaderValue);
            return chain.filter(exchange);
        };
    }
    // Class content
}
