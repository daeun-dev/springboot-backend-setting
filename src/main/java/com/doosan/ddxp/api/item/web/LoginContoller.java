package com.doosan.ddxp.api.item.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.doosan.ddxp.api.core.config.secuity.JwtAuthToken;
import com.doosan.ddxp.api.core.config.secuity.JwtAuthTokenProvider;

@Controller
public class LoginContoller {

	@GetMapping
	public JwtAuthToken login() {
		
		JwtAuthTokenProvider jwtAuthTokenProvider= new JwtAuthTokenProvider();
		JwtAuthToken token = jwtAuthTokenProvider.createLoginAuthToken("ddxploginID");
		return token;
		
	}
}
