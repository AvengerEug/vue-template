package com.tianma.sso.decodingjwt.model;

public class JwtProperties {

    private String header;
    private String cookie;
    private String type;
    private Long expiration;
    private String secret;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    private JwtProperties() {

    }

    @Override
    public String toString() {
        return "JwtProperties{" +
                "header='" + header + '\'' +
                ", cookie='" + cookie + '\'' +
                ", type='" + type + '\'' +
                ", expiration=" + expiration +
                ", secret='" + secret + '\'' +
                '}';
    }
}
