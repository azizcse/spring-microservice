package com.abg.gateway.service.impl;

import com.abg.gateway.config.GatewayDataConfiguration;
import com.abg.gateway.filter.AuthorizationFilter;
import com.abg.gateway.model.ApiRoute;
import com.abg.gateway.service.IApiRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.*;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/29/2023
 */
@RequiredArgsConstructor
public class ApiManagerServiceImpl implements RouteLocator {
    @Autowired
    private final IApiRouteService iApiRouteService;
    @Autowired
    private final AuthorizationFilter authorizationFilter;
    @Autowired
    private final RouteLocatorBuilder routeLocatorBuilder;

    @Override
    public Flux<Route> getRoutes() {
        System.out.println("Get routes API called ");
        GatewayFilter gatewayFilter = authorizationFilter.apply(new GatewayDataConfiguration());
        RouteLocatorBuilder.Builder routesBuilder = routeLocatorBuilder.routes();
        return iApiRouteService.findApiRoutes()
                .map(apiRoute -> routesBuilder.route(
                        String.valueOf(apiRoute.getId()),
                        predicateSpec -> setPredicateSpec(apiRoute, predicateSpec, gatewayFilter)))
                .collectList()
                .flatMapMany(builders -> routesBuilder.build().getRoutes());
    }

    private Buildable<Route> setPredicateSpec(ApiRoute apiRoute,
                                              PredicateSpec predicateSpec,
                                              GatewayFilter gatewayFilter) {
        System.out.println("Build route called for :" + apiRoute.getUri());

        BooleanSpec booleanSpec = predicateSpec.path(apiRoute.getPath());
        if (StringUtils.hasLength(apiRoute.getMethod()))
            booleanSpec.and().method(apiRoute.getMethod());

        UriSpec uriSpec = booleanSpec.filters(gatewayFilterSpec -> {
            System.out.println("Set filter");
            gatewayFilterSpec.filter(gatewayFilter);
            return gatewayFilterSpec;
        });

        return uriSpec.uri(apiRoute.getUri());
    }
}
