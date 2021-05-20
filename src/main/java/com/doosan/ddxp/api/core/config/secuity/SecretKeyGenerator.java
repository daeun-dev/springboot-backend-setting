//package com.doosan.ddxp.api.core.config.secuity;
//
//import javax.crypto.SecretKey;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Encoders;
//import io.jsonwebtoken.security.Keys;
//
//
//public class SecretKeyGenerator {
//
//	static SecretKey key;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        String secretKey = Encoders.BASE64URL.encode(key.getEncoded());
//        
//        Logger logger = LoggerFactory.getLogger(SecretKeyGenerator.class);
//        logger.info("SECRET_KEY:"+secretKey);;
//	}
//
//}
