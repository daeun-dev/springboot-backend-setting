package com.doosan.ddxp.api.item.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;

public class userSettingController {
	
	private LocaleResolver localeResolver;
	
	public void setLocale(LocaleResolver localeResolver) {
		this.localeResolver =  localeResolver;
	}
	
	@GetMapping("/changeLocale")
	public void changeLocale(HttpServletRequest request) {
		
		String localeCode = request.getParameter("locale");
		

		switch(localeCode) {
			case "en" : // 영어
				localeResolver.setLocale(null, null, Locale.ENGLISH);
				break;
			case "vn" : // 베트남
				localeResolver.setLocale(null, null, new Locale("vi", "VN"));
				break;
			case "nb" : // 노르웨이
				localeResolver.setLocale(null, null, new Locale("nb", "NO"));
				break;
			case "pt" : // 포르투갈
				localeResolver.setLocale(null, null, new Locale("pt", "PT"));
				break;
			case "es" : // 스페인어
				localeResolver.setLocale(null, null, new Locale("es", "ES"));
				break;
			case "nl" : // 네덜란드어
				localeResolver.setLocale(null, null, new Locale("nl", "NL"));
				break;
			case "sv" : //스웨덴어
				localeResolver.setLocale(null, null, new Locale("sv", "SE"));
				break;	
			case "fi" : //핀란드어
				localeResolver.setLocale(null, null, new Locale("fi", "FI"));
				break;		
			default:
				localeResolver.setLocale(null, null, Locale.ENGLISH);
				break;
		}
		
	}

}
