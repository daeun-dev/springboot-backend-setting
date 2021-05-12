package com.doosan.ddxp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.doosan.ddxp.api.item.domain.model.User;
import com.doosan.ddxp.api.item.domain.repository.loginRedisRepository;


public class RestTest {

	@Autowired
	private loginRedisRepository loginRedisRepository; 
	
	Logger logger = LoggerFactory.getLogger(RestTest.class);
	
	@Test
	public void testSave() {
		String id = "abc123";
		String password = "12345";
		User user = User.builder()
				.userId(id)
				.password(password)
				.build();

		loginRedisRepository.save(user);
		User refreshUser = loginRedisRepository.findById(id).get();
		assertEquals(id,refreshUser.getUserId());
		
		
	}
}
