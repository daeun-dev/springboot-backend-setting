package com.doosan.ddxp.api.core.config.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;
    
    @Bean
    public JwtAuthTokenProvider jwtProvider() {
    	return new JwtAuthTokenProvider(secret);
    	
    }
}
