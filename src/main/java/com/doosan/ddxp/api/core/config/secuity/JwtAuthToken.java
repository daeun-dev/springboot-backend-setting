package com.doosan.ddxp.api.core.config.secuity;



import java.security.Key;
import java.util.Date;
import java.util.Optional;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class JwtAuthToken implements AuthToken<Claims> {

    @Getter
    private final String token;
    private final Key key;



    JwtAuthToken(String token, Key key) {
        this.token = token;
       //this.key = secretKey;
        this.key = key;
    }

    JwtAuthToken(String subject, String id, Date expiredDate, Key key, Role role) {
        this.key = key;
        this.token = createJwtAuthToken(subject, id, expiredDate, role).get();
    }

    private Optional<String> createJwtAuthToken(String subject, String id, Date expiredDate, Role role) {
		
        var token = Jwts.builder()
        		.setIssuer("doosan.ddxp")								//발급자
    			.setIssuedAt(new Date(System.currentTimeMillis()))		//발급일시
    			.setExpiration(expiredDate)								//토큰 만료일시				
    			.setSubject(subject)									//토큰제목
                .claim("data", id) 										//계정정보
                .claim("authorization", role)							//권한정보						
                .setExpiration(expiredDate)
                .signWith(key)
                .compact();

        return Optional.ofNullable(token);
    }
    
    @Override
    public boolean validate() {
        return getData() != null;
    }

//    @Override
//    public Claims getData() {
//
//        try {
////        	return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
//        } catch (SecurityException e) {
//            log.info("Invalid JWT signature.");
////            throw new CustomJwtRuntimeException();
//        } catch (MalformedJwtException e) {
//            log.info("Invalid JWT token.");
////            throw new CustomJwtRuntimeException();
//        } catch (ExpiredJwtException e) {
//            log.info("Expired JWT token.");
////            throw new CustomJwtRuntimeException();
//        } catch (UnsupportedJwtException e) {
//            log.info("Unsupported JWT token.");
////            throw new CustomJwtRuntimeException();
//        } catch (IllegalArgumentException e) {
//            log.info("JWT token compact of handler are invalid.");
////            throw new CustomJwtRuntimeException();
//        }
//		return null;
//    }



@Override
public Claims getData() {
	// TODO Auto-generated method stub
	return null;
}
    
}