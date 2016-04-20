package com.orangeside.redis.cache;

import com.orangeside.common.cache.BasicCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by cgj on 2016/4/13.
 */
public class SimpleRedisCache implements BasicCache<String, Object> {
    @Autowired
    private RedisTemplate<String, Object> template;

    @Override
    public void set(String key, Object value) {
        template.opsForValue().set(key, value);
    }

    @Override
    public Object get(String key) {
        return template.opsForValue().get(key);
    }

    @Override
    public void del(String key) {
        template.opsForValue().set(key, null);
    }
}
