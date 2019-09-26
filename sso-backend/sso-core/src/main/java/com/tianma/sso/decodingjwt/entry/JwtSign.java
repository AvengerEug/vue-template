package com.tianma.sso.decodingjwt.entry;

import com.tianma.sso.decodingjwt.util.LoadJwtProperties;
import com.tianma.sso.decodingjwt.model.JwtProperties;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class JwtSign {

    private final Logger logger = LoggerFactory.getLogger(JwtSign.class);

    private final static String JWT_TOKEN_KEY = "jwt_token_key";

    private final static String HASHTAG = "#";

    private JwtProperties jwtProperty;

    {
        jwtProperty = LoadJwtProperties.newJwtPropertiesInstance();
    }

    public JwtProperties getJwtProperty() {
        return jwtProperty;
    }

    public String sign(String key, Object object) {
        long expiredTime = System.currentTimeMillis() + Long.valueOf(jwtProperty.getExpiration());

        return Jwts.builder().claim(key, object)
                .setExpiration(new Date(expiredTime))
                .signWith(SignatureAlgorithm.HS512, jwtProperty.getSecret()).compact();
    }

    public Jwt unSign(String jwtToken) {
        return Jwts.parser().setSigningKey(jwtProperty.getSecret()).parseClaimsJws(jwtToken);
    }

    public Object unSignHeader(String jwtToken) {
        return unSign(jwtToken).getHeader();
    }

    public Object unSignBody(String jwtToken) {
        return unSign(jwtToken).getBody();
    }

    public String buildJwtTokenRedisKey(String userName) {
        return new StringBuffer(userName).append(HASHTAG).append(JWT_TOKEN_KEY).toString();
    }

    public boolean isExpired(String jwtToken) {
        try {
            unSign(jwtToken);
            return false;
        } catch (ExpiredJwtException e) {
            logger.warn("Jwt-token has been expired.");
        }

        return true;
    }

    public static void main(String[] args) {
        new JwtSign();
    }
}
