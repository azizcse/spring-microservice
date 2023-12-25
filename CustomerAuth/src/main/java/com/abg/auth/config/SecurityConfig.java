package com.abg.auth.config;

import com.abg.auth.exception.UserAuthenticationErrorHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorize -> {
                            //authorize.requestMatchers(getAllowedUrls()).permitAll();
                            authorize.anyRequest().permitAll();
                        }
                ).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.userDetailsService(userDetailsService);
        return http.build();
    }

    @Bean
    public AuthenticationEntryPoint userAuthenticationErrorHandler() {
        UserAuthenticationErrorHandler userAuthenticationErrorHandler =
                new UserAuthenticationErrorHandler();
        userAuthenticationErrorHandler.setRealmName("Basic Authentication");
        return userAuthenticationErrorHandler;
    }


    private String[] getAllowedUrls() {
        return new String[]{
                "/api/v1/auth/token",
        };
    }


}
