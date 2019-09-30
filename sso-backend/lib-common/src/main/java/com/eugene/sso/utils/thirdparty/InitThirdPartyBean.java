package com.eugene.sso.utils.thirdparty;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.eugene.sso.decodingjwt.entry.JwtSign;
import org.springframework.context.annotation.Bean;

public class InitThirdPartyBean {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public JwtSign jwtSignUtil() {
        return new JwtSign();
    }
}
