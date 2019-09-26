package com.tianma.sso.annotation;

import com.tianma.sso.utils.thirdparty.InitThirdPartyBean;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {
        InitThirdPartyBean.class
})
public @interface EnableThirdPartyBean {
}
