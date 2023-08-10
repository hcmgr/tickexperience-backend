package com.deco.tickexperience.filter;

import com.deco.tickexperience.model.entity.User;
import com.deco.tickexperience.service.security.TokenService;
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
import org.springframework.stereotype.Component;

import java.io.IOException;

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

        // Validate active token
        if (TokenService.getUser(token) != null) {
            chain.doFilter(request, response);
            log.info("Token validated");
            return;
        }

        log.warn("Invalid token: {}", token);
        res.setStatus(401);
    }
}
