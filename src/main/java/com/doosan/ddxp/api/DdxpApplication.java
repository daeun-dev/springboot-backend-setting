package com.doosan.ddxp.api;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class DdxpApplication {

	public static void main(String[] args) {
		SpringApplication.run(DdxpApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
	  ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	  messageSource.setBasename("classpath:AppResources");
	  messageSource.setDefaultEncoding("UTF-8");
	  return messageSource;
	}

	@Bean
	public MessageSourceAccessor getMessageSourceAccessor(final MessageSource messageSource) {
	    return new MessageSourceAccessor(messageSource, Locale.US);
	}
	
	@Bean
	public LocaleResolver ddxplocaleResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}

}
