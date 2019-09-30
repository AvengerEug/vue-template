package com.eugene.sso.web.http;

public class Message {

    private final static Integer OK = 200;
    private final static Integer ERROR = 500;
    private final static Integer BAD_REQUEST = 400;

    private Integer statusCode;
    private Object data;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private static class SuccessMessage extends Message {

        public SuccessMessage() {
            super.statusCode = OK;
        }

        public SuccessMessage(Object data) {
            super.statusCode = OK;
            super.setData(data);
        }

    }

    private static class ErrorMessage extends Message {
        private String errorMessage;
        private String errorCode;

        public ErrorMessage(String errorMessage) {
            super.setStatusCode(ERROR);
            this.errorMessage = errorMessage;
        }

        public ErrorMessage(String errorCode, String errorMessage) {
            super.setStatusCode(ERROR);
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
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

    public static Message error(String errorCode, String message) {
        return new ErrorMessage(errorCode, message);
    }

}
