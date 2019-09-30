package com.eugene.sso.filter.configration;

import com.eugene.sso.factory.FilterFactory;
import com.eugene.sso.Enum.FilterOrderConstants;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 过滤器注册中心
 */
public class RegisterFilter {

    @Bean
    public FilterRegistrationBean firstFilter() {
        return FilterFactory.getFilter("firstFilter");
    }

    /*@Bean*/
    public FilterRegistrationBean authFilter() {
        return FilterFactory.getFilter("authFilter", "/*", FilterOrderConstants.AUTH_FILTER_ORDER);
    }

}
