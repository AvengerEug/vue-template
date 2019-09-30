package com.eugene.sso.controller;

import com.eugene.sso.exception.BusinessException;
import com.eugene.sso.web.http.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局处理异常控制器, 但它不是一个正在的控制器
 */
public class BaseController {

    private static final String DEFAULT_ERROR_MESSAGE = "系统异常";

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Message exceptionHandler(Exception e) {
        logger.error("发生异常", e);

        String errorMessage = DEFAULT_ERROR_MESSAGE;
        if (e instanceof BusinessException) {
            errorMessage = e.getMessage();
            return Message.error(((BusinessException) e).getCode(), errorMessage);
        }

        return Message.error(errorMessage);
    }
}
