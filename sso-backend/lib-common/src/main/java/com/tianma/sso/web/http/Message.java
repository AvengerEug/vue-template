package com.tianma.sso.web.http;

public class Message {

    public final static Integer OK = 200;
    private final static Integer ERROR = 500;
    private final static Integer BAD_REQUEST = 400;

    private Integer statusCode;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    private static class SuccessMessage extends Message {
        private Object data;

        public SuccessMessage() {
            super.statusCode = OK;
        }

        public SuccessMessage(Object data) {
            super.statusCode = OK;
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    private static class ErrorMessage extends  Message {
        private String errorMessage;

        public ErrorMessage(String errorMessage) {
            super.statusCode = ERROR;
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

    public static Message ok() {
        return new SuccessMessage();
    }

    public static Message ok(Object data) {
        return new SuccessMessage(data);
    }

    public static Message error(String message) {
        return new ErrorMessage(message);
    }

}
