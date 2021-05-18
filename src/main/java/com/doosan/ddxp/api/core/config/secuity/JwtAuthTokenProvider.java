package com.doosan.ddxp.api.core.config.secuity;

import java.security.Key;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthTokenProvider implements AuthTokenProvider<JwtAuthToken> {

    private final Key key;
    private Role role;
    
    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.login.expiredDate}")
    private int loginExpiredDate;

    public JwtAuthTokenProvider() {
		this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

/*    @Override
    public JwtAuthToken createLoginAuthToken(String id) {
    	
    	//권한 조회하는 로직
    	this.role = Role.MASTER;
        return new JwtAuthToken("doosan.ddxp.login", id, new Date(System.currentTimeMillis() + loginExpiredDate), key, role);
    } */

    @Override
    public JwtAuthToken createLoginAuthToken() {
    	return new JwtAuthToken(key);
    }
    
    @Override
    public JwtAuthToken convertAuthToken(String token) {
        return new JwtAuthToken(token, key);
    }

}