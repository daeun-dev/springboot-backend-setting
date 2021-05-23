package com.doosan.ddxp.api.core.config.secuity;



import java.security.Key;
import java.util.Date;
import java.util.Optional;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


public class JwtAuthToken {

    @Getter
    private final String token;
    private final Key key;

    //decode용
    JwtAuthToken(String token, Key key) {
        this.token = token;
        this.key = key;
    }

    JwtAuthToken(Key key) {
    	 this.key = key;
         this.token = createJwtAuthToken().get();
    }

//    JwtAuthToken(String subject, String id, Date expiredDate, Key key) {
//        this.key = key;
//        this.token = createJwtAuthToken(subject, id, expiredDate, role).get();
//    }

    private Optional<String> createJwtAuthToken() {
		
        var token = Jwts.builder()
                .signWith(key)
                .compact();

        return Optional.ofNullable(token);
    }

//    private Optional<String> createJwtAuthToken(String subject, String id, Date expiredDate) {
//		
//        var token = Jwts.builder()
//        		.setIssuer("doosan.ddxp")								//발급자
//    			.setIssuedAt(new Date(System.currentTimeMillis()))		//발급일시
//    			.setExpiration(expiredDate)								//토큰 만료일시				
//    			.setSubject(subject)									//토큰제목
//                .claim("data", id) 										//계정정보
//                .claim("authorization", role)							//권한정보						
//                .setExpiration(expiredDate)
//                .signWith(key)
//                .compact();
//
//        return Optional.ofNullable(token);
//    }



    
}