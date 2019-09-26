package com.tianma.sso.utils;

import com.tianma.sso.filter.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@ConditionalOnClass(JwtAuthFilter.class)
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    private void remove(final String ...keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    private void remove(String key) {
        redisTemplate.delete(key);
    }

    public void removePattern(final String pattern) {
        Set keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    public boolean isExists(final String key) {
        return redisTemplate.hasKey(key);
    }

    public Object get(Serializable key) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    public void set(Serializable key, Object value) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
    }

    public void set(Serializable key, Object object, Long expireTime) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key, object);
        redisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
    }
}
