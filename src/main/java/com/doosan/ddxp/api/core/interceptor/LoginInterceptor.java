package com.doosan.ddxp.api.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor{

    private static final String AUTHORIZATION_HEADER = "authorization";
    
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		final String token = request.getHeader(AUTHORIZATION_HEADER);
		if(token != null) {
			return true;
		}else {
			response.sendRedirect("/errorPage");
			return false;
		}

//	        if (token.isPresent()) {
//	            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
//	            if(jwtAuthToken.validate() & Role.MASTER.getCode().equals(jwtAuthToken.getData().get("authorization"))) {
//	                return true;
//	            }
//	            else {
//	            }
//	        } else {

//	        }
			
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}
	
}
