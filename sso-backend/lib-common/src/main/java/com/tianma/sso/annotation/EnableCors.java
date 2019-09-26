package com.tianma.sso.annotation;

import com.tianma.sso.web.mvc.MvcCorsConfig;
import com.tianma.sso.web.security.WebSecurityConfig;
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
