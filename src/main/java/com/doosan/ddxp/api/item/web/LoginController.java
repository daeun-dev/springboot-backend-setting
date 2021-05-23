package com.doosan.ddxp.api.item.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.doosan.ddxp.api.core.config.secuity.JwtAuthToken;
import com.doosan.ddxp.api.core.config.secuity.JwtAuthTokenProvider;

@Controller
public class LoginController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	
	@GetMapping(path = "/login")
	public ResponseEntity login() {
		
		Logger logger = LoggerFactory.getLogger(LoginController.class);
		
		JwtAuthTokenProvider jwtAuthTokenProvider= new JwtAuthTokenProvider();
		JwtAuthToken jwtToken = jwtAuthTokenProvider.createLoginAuthToken();
		
		ValueOperations<String, Object> vop = redisTemplate.opsForValue();
		vop.set(jwtToken.getToken(), "abc");
		
		System.out.println("TOKEN_VALUE111 :"+jwtToken.getToken());
		redisTemplate.expire(jwtToken.getToken(), 1,TimeUnit.HOURS);
		
		System.out.println("TOKEN_VALUE22222222");
		
		String result = (String) vop.get(jwtToken.getToken());
		System.out.println("AFTER_REDIS : "+result);
		URI uri = null;
		try {
			uri = new URI("https://devapi-dxp.doosaninfracore.com/dxp/test");
			System.out.println("TOKEN_VALUE3333333");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		//return "redirect:/test";
		return (ResponseEntity) ResponseEntity.ok().header("Authorization", jwtToken.getToken()).location(uri);
	}
}
