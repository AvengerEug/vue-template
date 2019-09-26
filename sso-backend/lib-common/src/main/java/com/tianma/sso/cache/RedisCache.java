package com.tianma.sso.cache;

import com.tianma.sso.utils.ApplicationContextHolder;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final String id;

    private RedisTemplate redisTemplate;

    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        try {
            HashOperations opsForHash = this.getHashOperation();
            opsForHash.put(id, key.toString(), value);
        } catch (Throwable throwable) {
            System.out.printf(throwable.toString());
        }
    }

    protected HashOperations getHashOperation() {
        return getRedisTemplate().opsForHash();
    }

    @Override
    public Object getObject(Object key) {
        try {
            HashOperations opsForHash = this.getHashOperation();
            return opsForHash.get(id, key.toString());
        } catch (Throwable throwable) {
            System.out.printf(throwable.toString());
            return null;
        }
    }

    @Override
    public Object removeObject(Object key) {
        try {
            HashOperations opsForHash = this.getHashOperation();
            return opsForHash.delete(id, key.toString());
        } catch (Throwable throwable) {
            System.out.printf(throwable.toString());
            return null;
        }
    }

    @Override
    public void clear() {
        redisTemplate.delete(this.id);
    }

    /**
     * This method is not used
     *
     * @return
     */
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    private RedisTemplate getRedisTemplate() {
        if (redisTemplate == null) {
            redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
        }

        return redisTemplate;
    }
}
