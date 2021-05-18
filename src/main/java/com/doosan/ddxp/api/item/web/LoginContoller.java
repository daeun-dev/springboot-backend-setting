package com.doosan.ddxp.api.item.web;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.doosan.ddxp.api.core.config.redis.GsonRedisSerializer;
import com.doosan.ddxp.api.core.config.secuity.JwtAuthToken;
import com.doosan.ddxp.api.core.config.secuity.JwtAuthTokenProvider;

@Controller
public class LoginContoller {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping("/Login")
	public void login() {
		
		JwtAuthTokenProvider jwtAuthTokenProvider= new JwtAuthTokenProvider();
		JwtAuthToken jwtToken = jwtAuthTokenProvider.createLoginAuthToken();
		
		redisTemplate.setKeySerializer(new GsonRedisSerializer());
		redisTemplate.setValueSerializer(new GsonRedisSerializer());
		
//		TokenBuilder tokenInfo = Token.builder()
//								  .id("abc")
//								  .expiredDate(date);
		
		redisTemplate.opsForValue().set(jwtToken.getToken(), "abc");
		redisTemplate.expire(jwtToken.getToken(), 1,TimeUnit.HOURS);
		
		logger.info("TOKEN_VALUE :"+jwtToken.getToken());
		
		String result = redisTemplate.opsForValue().get(jwtToken.getToken());
	
		logger.info("AFTER_REDIS : "+result);
		//loginRedisRepository.save(token);
		
		
	}
}
