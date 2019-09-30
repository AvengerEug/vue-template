package com.eugene.sso.web.mvc;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class MvcCorsConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedMethods("PUT", "GET", "POST", "DELETE", "OPTIONS")
            .allowedOrigins("*")
                // 同一个请求在20天内不需要再预检
            .maxAge(5 * 24 * 60 * 60);
    }
}
