package com.tianma.sso.filter;

import com.tianma.sso.web.model.WebContext;
import com.tianma.sso.utils.ContextUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Nothing to do
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;

        // 将servlet 容器中的request, response放入ThreadLoca中
        ContextUtil.setAttribute(ContextUtil.WEB_CONTEXT, new WebContext(httpServletRequest, httpServletResponse));
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Nothing to do
    }
}
