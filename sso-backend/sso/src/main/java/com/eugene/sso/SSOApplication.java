package com.eugene.sso;

import com.eugene.sso.annotation.EnableFilters;
import com.eugene.sso.annotation.EnableThirdPartyBean;
import com.eugene.sso.cache.RedisTemplateConfiguration;
import com.eugene.sso.annotation.EnableCors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFilters
@EnableCors
@EnableThirdPartyBean
@Import(value = { RedisTemplateConfiguration.class })
public class SSOApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SSOApplication.class);
        springApplication.run(args);
    }
}
