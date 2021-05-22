package com.doosan.ddxp.api.item.web;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doosan.ddxp.api.core.config.redis.GsonRedisSerializer;
import com.doosan.ddxp.api.core.config.secuity.JwtAuthToken;
import com.doosan.ddxp.api.core.config.secuity.JwtAuthTokenProvider;

@Controller
public class LoginController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	
	@ResponseBody
	@GetMapping(path = "/login")
	public String login() {
		
		Logger logger = LoggerFactory.getLogger(LoginController.class);
		
		JwtAuthTokenProvider jwtAuthTokenProvider= new JwtAuthTokenProvider();
		JwtAuthToken jwtToken = jwtAuthTokenProvider.createLoginAuthToken();
		
		System.out.println("TOKEN_VALUE111 :"+jwtToken.getToken());
		ValueOperations<String, Object> vop = redisTemplate.opsForValue();
		vop.set(jwtToken.getToken(), "abc");
//		redisTemplate.setKeySerializer(new GsonRedisSerializer());
//		redisTemplate.setValueSerializer(new GsonRedisSerializer());
		//redisTemplate.opsForValue().set(jwtToken.getToken(), "abc");
		System.out.println("TOKEN_VALUE22222222");
		redisTemplate.expire(jwtToken.getToken(), 1,TimeUnit.HOURS);
		
		System.out.println("TOKEN_VALUE333333333333:"+jwtToken.getToken());
		
		String result = (String) vop.get(jwtToken.getToken());
		System.out.println("AFTER_REDIS : "+result);
		
		return result;
		
	}
}
