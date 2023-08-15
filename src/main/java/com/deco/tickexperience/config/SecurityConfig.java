package com.deco.tickexperience.config;

import com.deco.tickexperience.filter.CorsFilter;
import com.deco.tickexperience.filter.RequestResponseLoggingFilter;
import com.deco.tickexperience.filter.TokenAuthFilter;
import com.deco.tickexperience.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private TokenService tokenService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilterRegistrationBean(){
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RequestResponseLoggingFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<TokenAuthFilter> tokenAuthFilterFilterRegistrationBean(){
        FilterRegistrationBean<TokenAuthFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new TokenAuthFilter(tokenService));
        // only apply this filter to methods that required an auth token
        registrationBean.addUrlPatterns("/api/authed/*");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterFilterRegistrationBean() {
        FilterRegistrationBean<CorsFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CorsFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return registrationBean;
    }
}
