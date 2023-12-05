package com.abg.gateway.config;

import com.abg.gateway.filter.AuthorizationFilter;
import com.abg.gateway.service.IApiRouteService;
import com.abg.gateway.service.impl.ApiManagerServiceImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/29/2023
 */
@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator routeLocator(IApiRouteService apiRouteService,
                                     AuthorizationFilter authorizationFilter,
                                     RouteLocatorBuilder routeLocatorBuilder) {
        System.out.println("Config called......");
        return new ApiManagerServiceImpl(apiRouteService,authorizationFilter, routeLocatorBuilder);
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }

}
