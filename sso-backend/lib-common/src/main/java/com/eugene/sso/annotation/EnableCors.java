package com.eugene.sso.annotation;

import com.eugene.sso.web.mvc.MvcCorsConfig;
import com.eugene.sso.web.security.WebSecurityConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Import(value = {
        WebSecurityConfig.class,
        MvcCorsConfig.class
})
public @interface EnableCors {
}
