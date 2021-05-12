package com.doosan.ddxp.api.item.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Getter;

@Getter
@RedisHash("user")
public class User {


    @Id
    private String userId;
    private String password;


    @Builder
    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

	/*
	 * public void refresh(long amount, LocalDateTime refreshTime){
	 * if(refreshTime.isAfter(this.refreshTime)){ // 저장된 데이터보다 최신 데이터일 경우
	 * this.amount = amount; this.refreshTime = refreshTime; } }
	 */  
}
