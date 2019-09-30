package com.eugene.sso.decodingjwt.util;

import com.eugene.sso.decodingjwt.model.JwtProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class LoadJwtProperties {

    private final static Logger logger = LoggerFactory.getLogger(LoadJwtProperties.class);

    private final static String PROPERTIES_NAME = "decodingjwt.properties";

    private final static String JWT_HEADER = "jwt.header";

    private final static String JWT_COOKIE = "jwt.cookie";

    private final static String JWT_TYPE = "jwt.type";

    private final static String JWT_EXPIRATION = "jwt.expiration";

    private final static String JWT_SECRET = "jwt.secret";

    public static JwtProperties jwtProperties = null;

    private static InputStream input = null;

    private static Properties properties = null;

    static {
        try {
            properties = new Properties();
            input = LoadJwtProperties.class.getClassLoader().getResourceAsStream(LoadJwtProperties.PROPERTIES_NAME);

            properties.load(input);
            logger.info("Load JWT properties success.");
        } catch (IOException e) {
            logger.error("Load JWT properties occur exception.", e);
        }
    }

    public synchronized static JwtProperties newJwtPropertiesInstance() {
        if (LoadJwtProperties.jwtProperties == null) {
            try {
                Class clz = JwtProperties.class;
                Constructor constructor = clz.getDeclaredConstructor();
                constructor.setAccessible(true);

                LoadJwtProperties.jwtProperties = (JwtProperties)constructor.newInstance();
                logger.info("Reflection new instance success.");
                logger.info("Start build jwtProperties attribute.");

                jwtProperties.setCookie(properties.getProperty(JWT_COOKIE));
                jwtProperties.setExpiration(Long.valueOf(properties.getProperty(JWT_EXPIRATION)));
                jwtProperties.setHeader(properties.getProperty(JWT_HEADER));
                jwtProperties.setSecret(properties.getProperty(JWT_SECRET));
                jwtProperties.setType(properties.getProperty(JWT_TYPE));

                logger.info("End build jwtProperties attribute. info: " + jwtProperties);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return LoadJwtProperties.jwtProperties;
    }
}
