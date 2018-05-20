package com.alkaid.dtmp.redis.boot.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class JedisClient {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    public String get(String key) {
        String string = stringRedisTemplate.opsForValue().get(key);
        return string;
    }

    public String set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return key;
    }

    public String hget(String hkey, String key) {
        String string = (String)stringRedisTemplate.opsForHash().get(hkey, key);
        return string;
    }

    public long hset(String hkey, String key, String value) {
        stringRedisTemplate.opsForHash().put(hkey, key, value);
        return 0;
    }

    public long incr(String key) {
        Long incr = stringRedisTemplate.opsForValue().increment(key, 1);
        return incr;
    }

    public long expire(String key, Integer second) {
        Long expire = stringRedisTemplate.opsForValue().getOperations().getExpire(key);
        stringRedisTemplate.opsForValue().getOperations().expire(key, second, TimeUnit.SECONDS);
        return expire;
    }

    public long ttl(String key) {
        // TODO
        return stringRedisTemplate.opsForValue().getOperations().getExpire(key);
    }

    public long del(String key) {
        stringRedisTemplate.opsForValue().getOperations().delete(key);
        return 0;
    }

    public long hdel(String hkey, String key) {
        return stringRedisTemplate.opsForHash().delete(hkey, key);
    }
}
