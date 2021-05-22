package com.doosan.ddxp.api.core.config.secuity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

//	 	@Value("${spring.redis.host}")
	    private String redisHostName="w-awps-di-an2-ecrds-dev-dxp.wimlsn.0001.apn2.cache.amazonaws.com";

//	    @Value("${spring.redis.port}")
	    private int redisPort=6379;

	    @Bean
	    public RedisConnectionFactory redisConnectionFactory() {
	        return new LettuceConnectionFactory(redisHostName, redisPort);
	    }

	    @Bean
	    public RedisTemplate<?, ?> redisTemplate() {
	        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
	        redisTemplate.setConnectionFactory(redisConnectionFactory());
	        return redisTemplate;
	    }
    
}	    