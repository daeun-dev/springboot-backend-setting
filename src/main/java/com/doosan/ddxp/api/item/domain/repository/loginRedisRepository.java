package com.doosan.ddxp.api.item.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.doosan.ddxp.api.item.domain.model.User;

public interface loginRedisRepository extends CrudRepository<User, String>{
	
}
