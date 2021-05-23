package com.doosan.ddxp.api.core.interceptor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.doosan.ddxp.api.core.config.secuity.JwtAuthTokenProvider;


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

//	        Optional<String> token = resolveToken(request);

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
	
	 private Optional<String> resolveToken(HttpServletRequest request) {
	        String authToken = request.getHeader(AUTHORIZATION_HEADER);
	        if (StringUtils.hasText(authToken)) {
	            return Optional.of(authToken);
	        } else {
	            return Optional.empty();
	        }

	    }

}
