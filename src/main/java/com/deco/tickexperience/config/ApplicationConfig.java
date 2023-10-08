package com.deco.tickexperience.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:.env") // Load .env file
public class ApplicationConfig {
}
