package com.abg.gateway.filter;

import com.abg.gateway.config.GatewayDataConfiguration;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/28/2023
 */
@Component
public class AuthorizationFilter extends AbstractGatewayFilterFactory<GatewayDataConfiguration> {
    @Override
    public GatewayFilter apply(GatewayDataConfiguration config) {
        return null;
    }
    // Class content
}
