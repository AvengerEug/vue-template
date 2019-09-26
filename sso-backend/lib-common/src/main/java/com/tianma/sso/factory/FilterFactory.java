package com.tianma.sso.factory;

import com.tianma.sso.filter.FirstFilter;
import com.tianma.sso.filter.JwtAuthFilter;
import com.tianma.sso.constants.FilterOrderConstants;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

public abstract class FilterFactory {

    private static final String DEFAULT_PATTER = "/*";
    private static final Integer DEFAULT_ORDER = FilterOrderConstants.HIGH_PRIORITY;
    private static final Integer AUTH_FILTER_ORDER = FilterOrderConstants.AUTH_FILTER_ORDER;

    public static FilterRegistrationBean getFilter(String key) {
        return FilterFactory.constructorFilter(key, DEFAULT_PATTER, DEFAULT_ORDER);
    }

    public static FilterRegistrationBean getFilter(String key, String patter, Integer order) {
        return FilterFactory.constructorFilter(key, patter, order);
    }

    private static FilterRegistrationBean constructorFilter(String key, String patter, Integer order) {
        FilterRegistrationBean registrationBean = null;
        switch (key) {
            case "firstFilter":
                registrationBean = new FilterRegistrationBean(new FirstFilter());
                break;
            case "authFilter":
                registrationBean = new FilterRegistrationBean(new JwtAuthFilter());
                break;
            default:
                registrationBean = new FilterRegistrationBean(new FirstFilter());
        }
        registrationBean.addUrlPatterns(patter == null ? DEFAULT_PATTER : patter);
        registrationBean.setName(key);
        registrationBean.setOrder(order == null ? AUTH_FILTER_ORDER : order);

        return registrationBean;
    }

}
