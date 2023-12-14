package com.abg.auth.common.error;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 12/5/2023
 */
@Component
public class AuthenticationFailure implements AuthenticationEntryPoint {
    Logger logger = LoggerFactory.getLogger(AuthenticationFailure.class);

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        logger.info("Secured api called.....");
    }
    // Class content
}
