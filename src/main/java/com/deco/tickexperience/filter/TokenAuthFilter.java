package com.deco.tickexperience.filter;

import com.deco.tickexperience.service.TokenService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Filter to validate token
 * for requests that require
 * an authenticated user
 */
@WebFilter("/api/authed/*")
@RequiredArgsConstructor
@Slf4j
public class TokenAuthFilter implements Filter {


    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String token = req.getHeader("token");

        if (token == null) {
            log.warn("Missing token");
            res.setStatus(400);
            return;
        }

        if (TokenService.getUser(token) == null) {
            log.warn("Invalid token: {}", token);
            res.setStatus(401);
            return;
        }

        log.info("Token validated");
        chain.doFilter(request, response);
    }
}
