package com.abg.gateway.repository;

import com.abg.gateway.model.ApiRoute;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/28/2023
 */
@Repository
public interface ApiRouteRepository extends ReactiveCrudRepository<ApiRoute, Long> {
    // Class content
}