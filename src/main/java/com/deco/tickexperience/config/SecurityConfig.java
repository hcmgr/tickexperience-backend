package com.deco.tickexperience.config;

import com.deco.tickexperience.filter.RequestResponseLoggingFilter;
import com.deco.tickexperience.filter.TokenAuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class SecurityConfig {

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

        registrationBean.setFilter(new TokenAuthFilter());
        // only apply this filter to methods that required an auth token
        registrationBean.addUrlPatterns("/api/authed/*");

        return registrationBean;
    }
}
