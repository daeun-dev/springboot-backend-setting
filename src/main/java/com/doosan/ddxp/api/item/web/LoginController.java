package com.doosan.ddxp.api.item.web;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doosan.ddxp.api.core.config.redis.GsonRedisSerializer;
import com.doosan.ddxp.api.core.config.secuity.JwtAuthToken;
import com.doosan.ddxp.api.core.config.secuity.JwtAuthTokenProvider;

@Controller
public class LoginController {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@ResponseBody
	@GetMapping(path = "/login")
	public String login() {
		
		
		JwtAuthTokenProvider jwtAuthTokenProvider= new JwtAuthTokenProvider();
		JwtAuthToken jwtToken = jwtAuthTokenProvider.createLoginAuthToken();
		
		//logger.info("TOKEN_VALUE :"+jwtToken.getToken());
		System.out.println("TOKEN_VALUE111 :"+jwtToken.getToken());
		redisTemplate.setKeySerializer(new GsonRedisSerializer());
		redisTemplate.setValueSerializer(new GsonRedisSerializer());

		
		redisTemplate.opsForValue().set(jwtToken.getToken(), "abc");
		redisTemplate.expire(jwtToken.getToken(), 1,TimeUnit.HOURS);
		
		logger.info("TOKEN_VALUE222 :"+jwtToken.getToken());
		
		String result = redisTemplate.opsForValue().get(jwtToken.getToken());
	
		logger.info("AFTER_REDIS : "+result);
		//loginRedisRepository.save(token);
		
		return result;
		
	}
}
