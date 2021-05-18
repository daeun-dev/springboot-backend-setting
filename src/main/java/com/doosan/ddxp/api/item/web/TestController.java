package com.doosan.ddxp.api.item.web;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doosan.ddxp.api.core.config.redis.GsonRedisSerializer;
import com.doosan.ddxp.api.core.config.secuity.JwtAuthToken;
import com.doosan.ddxp.api.core.config.secuity.JwtAuthTokenProvider;
import com.doosan.ddxp.api.core.exception.BadRequestException;

@Controller
public class TestController {
	
	@Autowired
	private MessageSource messageSource;
	
//	@Autowired
//	private ItemService itemService;
	
	@Autowired
	private StringRedisTemplate redisTemplate;

	Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@ResponseBody
	@GetMapping(path = "/test")
	public String test() {
//		Logger logger = LoggerFactory.getLogger(TestController.class);
		
//		List<Item> itemList = itemService.getItemList();
//		int size = itemList.size();
//		logger.info(String.valueOf(size));
		

		JwtAuthTokenProvider jwtAuthTokenProvider= new JwtAuthTokenProvider();
		JwtAuthToken jwtToken = jwtAuthTokenProvider.createLoginAuthToken();
		
		logger.info("TOKEN_VALUE :"+jwtToken.getToken());
		redisTemplate.setKeySerializer(new GsonRedisSerializer());
		redisTemplate.setValueSerializer(new GsonRedisSerializer());

		
		redisTemplate.opsForValue().set(jwtToken.getToken(), "abc");
		redisTemplate.expire(jwtToken.getToken(), 1,TimeUnit.HOURS);
		
		logger.info("TOKEN_VALUE :"+jwtToken.getToken());
		
		String result = redisTemplate.opsForValue().get(jwtToken.getToken());
	
		logger.info("AFTER_REDIS : "+result);
		//loginRedisRepository.save(token);
		
		return "DDXP TEST";
	}
	
	@ResponseBody
	@GetMapping(path = "/test-internationalized")
	public String testInternationalized(Locale locale) {
		return messageSource.getMessage("test.message", null, locale);
	}
	
	@ResponseBody
	@GetMapping(path = "/errorTest")
	public void errorTest() throws Exception {
				
			throw new BadRequestException("badRequest");
	}
	
	@GetMapping(path = "/testPage")
	public String testPage(){
				
			return "common/test";
	}
}
