package com.alkaid.dtmp.redis.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alkaid.dtmp.common.constants.DtmpConstants;
import com.alkaid.dtmp.redis.api.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@Service(version = DtmpConstants.DTMP_REDIS_VERSION)
public class JedisClientSingle implements JedisClient {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String get(String key) {
        String string = stringRedisTemplate.opsForValue().get(key);
        return string;
    }

    @Override
    public String set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return key;
    }

    @Override
    public String hget(String hkey, String key) {
        String string = (String)stringRedisTemplate.opsForHash().get(hkey, key);
        return string;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        stringRedisTemplate.opsForHash().put(hkey, key, value);
        return 0;
    }

    @Override
    public long incr(String key) {
        Long incr = stringRedisTemplate.opsForValue().increment(key, 1);
        return incr;
    }

    @Override
    public long expire(String key, Integer second) {
        Long expire = stringRedisTemplate.opsForValue().getOperations().getExpire(key);
        stringRedisTemplate.opsForValue().getOperations().expire(key, second, TimeUnit.SECONDS);
        return expire;
    }

    @Override
    public long ttl(String key) {
        // TODO
        return stringRedisTemplate.opsForValue().getOperations().getExpire(key);
    }

    @Override
    public long del(String key) {
        stringRedisTemplate.opsForValue().getOperations().delete(key);
        return 0;
    }

    @Override
    public long hdel(String hkey, String key) {
        return stringRedisTemplate.opsForHash().delete(hkey, key);
    }
}
