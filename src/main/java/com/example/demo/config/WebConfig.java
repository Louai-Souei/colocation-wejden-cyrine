package com.example.demo.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull CorsRegistry registry) {
                registry.addMapping("/**") // Autoriser tous les endpoints
                        .allowedOrigins("http://localhost:3000") // Frontend React
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*"); // Tous les headers sont autorisés
            }
        };
    }
}
