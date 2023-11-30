package com.abg.gateway.service;


import com.abg.gateway.model.ApiRoute;
import reactor.core.publisher.Flux;

public interface IApiRouteService {
    Flux<ApiRoute> findApiRoutes();
    Flux<ApiRoute> findApiRoutesRedis();
}
