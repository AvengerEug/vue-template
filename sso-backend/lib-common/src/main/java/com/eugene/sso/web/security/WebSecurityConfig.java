package com.eugene.sso.web.security;

import com.eugene.sso.Enum.FilterOrderConstants;
import com.eugene.sso.factory.FilterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(
                        "/**"
                )
                .permitAll()
                .anyRequest().authenticated();

        http.headers().cacheControl().disable();

        http.addFilterBefore(FilterFactory.getFilter("authFilter", "/*", FilterOrderConstants.AUTH_FILTER_ORDER).getFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
