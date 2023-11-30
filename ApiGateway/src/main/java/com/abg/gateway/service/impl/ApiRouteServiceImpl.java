package com.abg.gateway.service.impl;

import com.abg.gateway.model.ApiRoute;
import com.abg.gateway.repository.ApiRouteRepository;
import com.abg.gateway.service.IApiRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/28/2023
 */
@Service
public class ApiRouteServiceImpl implements IApiRouteService {
    @Autowired
    private ApiRouteRepository apiRouteRepository;
    @Override
    public Flux<ApiRoute> findApiRoutes() {
        return null;
    }

    @Override
    public Flux<ApiRoute> findApiRoutesRedis() {
        return null;
    }
    // Class content
}
