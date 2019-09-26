package com.tianma.sso.constants;

public class FilterOrderConstants {

    /**
     * 值越小 优先级越高
     */
    public static final Integer HIGH_PRIORITY = Integer.MIN_VALUE;

    private static final Integer STEP = 10;

    public static final Integer AUTH_FILTER_ORDER = HIGH_PRIORITY + STEP;
}
