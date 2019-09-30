package com.eugene.sso.utils;

import com.eugene.sso.web.model.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Thread Local
 * 存放servlet容器中的request和response以及其他的key, value键值对
 */
public class ContextUtil {

    public static final String WEB_CONTEXT = "webContext";
    public static final String JWT_TOKEN = "jwt-token";
    public static final String CLIENT_TYPE = "clientType";

    private static final ThreadLocal<ContextUtil> threadLocal = new ThreadLocal<ContextUtil>();
    private HashMap<String, Object> attributes = null;

    private ContextUtil() {
        this.setAttributes(new HashMap<String, Object>());
    }

    public HashMap<String, Object> getAttributes() {
        return attributes;
    }

    private void setAttributes(HashMap<String, Object> attributes) {
        this.attributes = attributes;
    }

    /**
     * 获取实例方法, 单例模式 先从ThreadLocal中获取 若为空则调用私有化构造方法 构建对象并放入ThreadLocal中
     * @return
     */
    public static ContextUtil getInstance() {
        ContextUtil context = threadLocal.get();
        if (context == null) {
            context = new ContextUtil();
            threadLocal.set(context);
        }
        return context;
    }

    public static void setAttribute(String key, Object object) {
        ContextUtil context = ContextUtil.getInstance();
        context.getAttributes().put(key, object);
    }

    public static <T> T getAttribute(String key) {
        ContextUtil context = ContextUtil.getInstance();
        Map<String, Object> mapInner = context.getAttributes();
        return (T)(mapInner.containsKey(key) ? mapInner.get(key) : null);
    }

    public static void clearContext() {
        ContextUtil context = ContextUtil.getInstance();
        if (context != null) {
            threadLocal.remove();
            context = null;
        }
    }

    public static WebContext getWebContext() {
        return (WebContext) ContextUtil.getInstance().getAttributes().get(WEB_CONTEXT);
    }

    public static HttpServletRequest getHttpServletRequest() {
        return ContextUtil.getWebContext().getRequest();
    }

    public static HttpServletResponse getHttpServletResponse() {
        return ContextUtil.getWebContext().getResponse();
    }
}
