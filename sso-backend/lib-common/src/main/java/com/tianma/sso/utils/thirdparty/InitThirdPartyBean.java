package com.tianma.sso.utils.thirdparty;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tianma.sso.decodingjwt.entry.JwtSign;
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
