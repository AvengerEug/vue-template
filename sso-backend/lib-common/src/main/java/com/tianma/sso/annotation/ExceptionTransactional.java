package com.tianma.sso.annotation;

import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * 自定义事务方法级别注解, 当方法抛出Exception类型异常时, 回滚事务
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Transactional(rollbackFor = Exception.class)
public @interface ExceptionTransactional {
}
