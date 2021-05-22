package com.doosan.ddxp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DdxpApplication {

	public static void main(String[] args) {
		SpringApplication.run(DdxpApplication.class, args);
	}
	
//	@Bean
//	public MessageSource messageSource() {
//	  ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//	  messageSource.setBasename("classpath:AppResources");
//	  messageSource.setDefaultEncoding("UTF-8");
//	  return messageSource;
//	}
//
//	@Bean
//	public MessageSourceAccessor getMessageSourceAccessor(final MessageSource messageSource) {
//	    return new MessageSourceAccessor(messageSource, Locale.US);
//	}
//	
//	@Bean
//	public LocaleResolver ddxplocaleResolver() {
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//		localeResolver.setDefaultLocale(Locale.ENGLISH);
//		return localeResolver;
//	}

}
