package com.doosan.ddxp.api.core.config;

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

	 	@Value("${spring.redis.host}")
	    private String redisHostName;


	    @Value("${spring.redis.port}")
	    private int redisPort;

	    @Bean
	    public RedisConnectionFactory redisConnectionFactory() {
	    	System.out.println("redisHostName :"+redisHostName);
	    	System.out.println("redisPort :"+redisPort);
	        return new LettuceConnectionFactory(redisHostName, redisPort);
	    }

	    @Bean
	    public RedisTemplate<?, ?> redisTemplate() {
	        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
	        redisTemplate.setConnectionFactory(redisConnectionFactory());
	        return redisTemplate;
	    }
    
}	    
