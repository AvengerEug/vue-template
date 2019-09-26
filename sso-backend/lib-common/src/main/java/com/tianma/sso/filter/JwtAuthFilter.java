package com.tianma.sso.filter;

import com.tianma.sso.decodingjwt.entry.JwtSign;
import com.tianma.sso.utils.ApplicationContextHolder;
import com.tianma.sso.utils.ContextUtil;
import com.tianma.sso.utils.RedisUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class JwtAuthFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthFilter.class);

    private List<String> noAuthURI;

    {
        this.initNoAuthURI();
    }

    private void initNoAuthURI() {
        noAuthURI = Arrays.asList(new String[] {
                "/user/login", "/user/decoding-jwt-token"
        });
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Boolean needFilter = !noAuthURI.contains(request.getRequestURI());

        if (needFilter) {
            String jwtToken = request.getHeader("jwt-token");
            logger.info(jwtToken);

            if (jwtToken == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "无token");
                return;
            } else if (jwtToken != null && !validateJwtToken(jwtToken)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "token失效");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Nothing to do
    }

    private String getJwtToken(HttpServletRequest request) {
        return request.getHeader(ContextUtil.JWT_TOKEN);
    }

    /**
     *
     * @param jwtToken
     * @return false -> 非法
     */
    private boolean validateJwtToken(String jwtToken) {
        JwtSign jwtSign = ApplicationContextHolder.getBean("jwtSignUtil");
        RedisUtil redisUtil = ApplicationContextHolder.getBean("redisUtil");

        if (jwtSign.isExpired(jwtToken)) {
            logger.error("jwt-token已过期: " + jwtToken);
            return false;
        }

        Map<String, Object> info = (Map<String, Object>) jwtSign.unSignBody(jwtToken);
        Set<String> keys = info.keySet();
        Iterator<String> iterator = keys.iterator();
        // 第一个key对应的value为自定义数据
        String key = iterator.hasNext() ? iterator.next() : null;
        return (key != null) &&
                redisUtil.isExists(jwtSign.buildJwtTokenRedisKey(key)) &&
                matchRedisToken(jwtSign.buildJwtTokenRedisKey(key), jwtToken);
    }

    private String getRedisToken(String key) {
        RedisUtil redisUtil = ApplicationContextHolder.getBean("redisUtil");
        return (String)redisUtil.get(key);
    }

    private boolean matchRedisToken(String key, String jwtToken) {
        return getRedisToken(key).equals(jwtToken);
    }
}
