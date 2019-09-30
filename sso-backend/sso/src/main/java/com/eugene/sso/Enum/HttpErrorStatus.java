package com.eugene.sso.Enum;

public enum HttpErrorStatus {


    /**
     * 用户模块:       代号100
     * controller层   代码100
     * (service层     代号200     dao层   代号: 300  以此类推)
     * 业务代码:       代码0001  依次递增
     */
    USER_LOGIN_ERROR("100200001", "用户名或密码错误"),
    USER_REGISTER_USERNAME_ERROR("100200002", "用户名已存在, 无法创建账号");


    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private HttpErrorStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }


}
