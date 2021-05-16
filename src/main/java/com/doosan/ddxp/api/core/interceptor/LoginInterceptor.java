package com.doosan.ddxp.api.core.interceptor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.doosan.ddxp.api.core.config.secuity.JwtAuthToken;
import com.doosan.ddxp.api.core.config.secuity.JwtAuthTokenProvider;
import com.doosan.ddxp.api.core.config.secuity.Role;


public class LoginInterceptor implements HandlerInterceptor{

    private final JwtAuthTokenProvider jwtAuthTokenProvider = new JwtAuthTokenProvider();
    private static final String AUTHORIZATION_HEADER = "x-auth-token";
    
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

	        Optional<String> token = resolveToken(request);

	        if (token.isPresent()) {
	            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
	            if(jwtAuthToken.validate() & Role.MASTER.getCode().equals(jwtAuthToken.getData().get("authorization"))) {
	                return true;
	            }
	            else {
//	                throw new CustomAuthenticationException();
	            }
	        } else {
//	            throw new CustomAuthenticationException();
	        }
			return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}
	
	 private Optional<String> resolveToken(HttpServletRequest request) {
	        String authToken = request.getHeader(AUTHORIZATION_HEADER);
	        if (StringUtils.hasText(authToken)) {
	            return Optional.of(authToken);
	        } else {
	            return Optional.empty();
	        }

	    }

}
