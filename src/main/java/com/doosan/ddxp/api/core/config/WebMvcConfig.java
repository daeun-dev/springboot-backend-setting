package com.doosan.ddxp.api.core.config;

import java.util.Locale;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.doosan.ddxp.api.core.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/")
				.excludePathPatterns("/login");
		
		registry.addInterceptor(localeChangeInterceptor());
	}

	/* 
	 * 다국어 관련 
	 */
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	      LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	      lci.setParamName("lang");
	      return lci;
	}
	

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/template/");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		registry.jsp("/",".html");
	}
	
	@Bean
	public SimpleMappingExceptionResolver getExceptionResolver() {
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		
		resolver.setDefaultErrorView(null);
		resolver.setDefaultStatusCode(200);
		
		Properties prop = new Properties();
		prop.put("com.doosan.ddxp.api.core.exception.BadRequestException", "common/error/badRequestError");
		resolver.setExceptionMappings(prop);
		
		return resolver;
	}
	


}
