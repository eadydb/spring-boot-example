package com.eadydb.boot.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:35
 * <p/>
 * @Description
 */
@Configuration
@Slf4j
public class RedisConfig {

    @Bean
    @ConfigurationProperties(prefix = "redis")
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @ConfigurationProperties(prefix = "redis")
    public JedisConnectionFactory getConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        log.info("JedisConnectionFactory bean init success.");
        return factory;
    }

    @Bean
    public RedisTemplate<String, Object> getRedisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(getConnectionFactory());
        return template;
    }

}
