package com.doosan.ddxp.api.core.config.jwt;

import java.security.Key;

import io.jsonwebtoken.security.Keys;


public class JwtAuthTokenProvider {

    private final Key key;

    
    
    public JwtAuthTokenProvider(String secret) {
		this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public JwtAuthToken createLoginAuthToken(String id) {    	
    	return new JwtAuthToken(key, id);
    }
    
    
//    public JwtAuthToken convertAuthToken(String token) {
//        return new JwtAuthToken(token, key);
//    }

}