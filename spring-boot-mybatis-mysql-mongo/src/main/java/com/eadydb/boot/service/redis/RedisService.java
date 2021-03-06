package com.eadydb.boot.service.redis;

import com.eadydb.boot.dao.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:57
 * <p/>
 * @Description
 */
@Service("redisService")
@Slf4j
public class RedisService implements IRedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String PRE_HM_KEY = "AI_KEY@HM#";

    private static final String PRE_KV_KEY = "AI_KEY@KV#";

    /**
     * 基本数据类型的存储操作，即单一的Key vs Value结构。
     *
     * @param key
     * @param value
     * @param expireTime 超时时间数 (单位为second)
     * @return
     */
    @Override
    public boolean putValue(String key, Object value, long expireTime) {
        boolean res = false;
        if (StringUtils.isBlank(key) || null == value) {
            return false;
        }
        try {
            String tempKey = PRE_KV_KEY + key;
            ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(tempKey, value);
            redisTemplate.expire(tempKey, expireTime, TimeUnit.SECONDS);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("redis缓存数据【key：" + key + "】异常", e);
            res = false;
        }
        return res;
    }

    /**
     * 基本数据类型的取值。
     *
     * @param key
     * @return
     */
    @Override
    public Object getValue(String key) {
        try {
            String tempKey = PRE_KV_KEY + key;
            Object value =  redisTemplate.opsForValue().get(tempKey);
            return value;
        } catch (Exception e) {
            log.error("redis获取数据【key：" + key + "】异常", e);
            return null;
        }
    }

    /**
     * 删除基本数据类型中的指定key对应的值
     *
     * @param key
     * @return
     */
    public boolean removeValue(String key) {
        try {
            String tempKey = PRE_KV_KEY + key;
            redisTemplate.delete(tempKey);
            return true;
        } catch (Exception e) {
            log.error("redis获取数据【key：" + key + "】异常", e);
            return false;
        }
    }
}
