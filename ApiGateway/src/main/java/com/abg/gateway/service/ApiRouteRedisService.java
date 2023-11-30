package com.abg.gateway.service;

import com.abg.gateway.repository.ApiRouteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/28/2023
 */
@Service
@AllArgsConstructor
public class ApiRouteRedisService {
    private static final String HASH_KEY = "API_ROUTE_ACCESS_SERVICE";
    private final ObjectMapper objectMapper;
    private final ApiRouteRepository apiRouteRepository;
}
