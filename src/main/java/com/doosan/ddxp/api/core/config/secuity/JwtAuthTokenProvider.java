package com.doosan.ddxp.api.core.config.secuity;

import java.security.Key;

import io.jsonwebtoken.security.Keys;


public class JwtAuthTokenProvider {

    private final Key key;
    
//    @Value("${jwt.secret}")
    private String secret="dgViIpUMvyUow_g6hvdf_4XxRtcsSFlOW0bcIGTG5OE";
    
//    @Value("${jwt.login.expiredDate}")
//    private int loginExpiredDate;

    public JwtAuthTokenProvider() {
		this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

/*    @Override
    public JwtAuthToken createLoginAuthToken(String id) {
    	
    	//권한 조회하는 로직
    	this.role = Role.MASTER;
        return new JwtAuthToken("doosan.ddxp.login", id, new Date(System.currentTimeMillis() + loginExpiredDate), key, role);
    } */

    
    public JwtAuthToken createLoginAuthToken() {
    	return new JwtAuthToken(key);
    }
    
    
    public JwtAuthToken convertAuthToken(String token) {
        return new JwtAuthToken(token, key);
    }

}