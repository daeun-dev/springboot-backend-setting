package com.doosan.ddxp.api.item.web;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.doosan.ddxp.api.item.domain.model.User;
import com.doosan.ddxp.api.item.domain.repository.loginRedisRepository;

@Component
public class RestController implements ApplicationRunner {

	@Autowired
	private loginRedisRepository loginRedisRepository; 
	
	@Autowired
	private StringRedisTemplate redisTemplate;


	/**public void run(ApplicationArguments args) throws Exception {
		ValueOperations<String,String> values = redisTemplate.opsForValue();
		values.set("aaaa","1111");
		values.set("bbbb","2222");
		values.set("cccc","3333");
	}**/

	public void run(ApplicationArguments args) throws Exception {
		String id = "abc123"; 
		String password="12345";
		User user = new User(id, password);
//		
//		loginRedisRepository.save(user);
//		
//		Optional<User> findUser = loginRedisRepository.findById(user.getUserId());
//
//		System.out.println(findUser.get().getUserId());
//		System.out.println(findUser.get().getPassword());
		
	}
}
