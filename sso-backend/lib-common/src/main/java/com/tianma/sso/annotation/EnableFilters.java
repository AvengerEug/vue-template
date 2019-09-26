package com.tianma.sso.annotation;

import com.tianma.sso.filter.configration.RegisterFilter;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(value = { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {
        RegisterFilter.class
})
public @interface EnableFilters {
}
