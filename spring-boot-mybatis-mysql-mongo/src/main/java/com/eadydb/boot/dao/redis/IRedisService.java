package com.eadydb.boot.dao.redis;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:50
 * <p/>
 * @Description
 */
public interface IRedisService {

    public boolean putValue(String key, Object value, long expireTime);

    public Object getValue(String key);
}
