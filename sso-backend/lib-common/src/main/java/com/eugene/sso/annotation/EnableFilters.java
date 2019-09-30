package com.eugene.sso.annotation;

import com.eugene.sso.filter.configration.RegisterFilter;
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
