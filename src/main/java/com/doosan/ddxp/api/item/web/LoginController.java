package com.doosan.ddxp.api.item.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<?> login() {
		
		Logger logger = LoggerFactory.getLogger(LoginController.class);
		
		JwtAuthTokenProvider jwtAuthTokenProvider= new JwtAuthTokenProvider();
		JwtAuthToken jwtToken = jwtAuthTokenProvider.createLoginAuthToken();
		
		String id = "ddxp";
		ValueOperations<String, Object> vop = redisTemplate.opsForValue();
		vop.set(jwtToken.getToken(), id);
		
		System.out.println("TOKEN_VALUE111 :"+jwtToken.getToken());
		redisTemplate.expire(jwtToken.getToken(), 1,TimeUnit.HOURS);
		
		System.out.println("TOKEN_VALUE22222222");
		
		String result = (String) vop.get(jwtToken.getToken());
		System.out.println("AFTER_REDIS : "+result);
		
		
		URI uri = null;
		HttpHeaders headers = null;
		ResponseEntity<?> responseEntity = null;
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		
		try {
			uri = new URI("https://devapi-dxp.doosaninfracore.com/dxp/main");
			//uri = new URI("http://www.naver.com");
			headers = new HttpHeaders();
			headers.set("Authorization", jwtToken.getToken());
			headers.setLocation(uri);
			responseEntity = ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
								.headers(headers)
								.location(uri)
								.body(map);
			
			System.out.println("TOKEN_VALUE3333333");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		//return "redirect:/test";
		return responseEntity;
	}
}
