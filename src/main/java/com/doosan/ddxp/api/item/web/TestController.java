package com.doosan.ddxp.api.item.web;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doosan.ddxp.api.core.exception.BadRequestException;
import com.doosan.ddxp.api.item.domain.model.Item;
import com.doosan.ddxp.api.item.domain.service.ItemService;

@Controller
public class TestController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ItemService itemService;

	Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@ResponseBody
	@GetMapping(path = "/test")
	public String test() {
//		Logger logger = LoggerFactory.getLogger(TestController.class);
		
		System.out.println("TESTTESTDDXP!!!1");
		
		List<Item> itemList = itemService.getItemList();
		int size = itemList.size();
		logger.info(String.valueOf(size));
		return "DDXP TEST!!!dfdf";
	}
	
	@ResponseBody
	@GetMapping(path = "/test-internationalized")
	public String testInternationalized(Locale locale) {
		return messageSource.getMessage("test.message", null, locale);
	}
	
	@ResponseBody
	@GetMapping(path = "/errorTest")
	public void errorTest() throws Exception {
				
			throw new BadRequestException("badRequest");
	}
	
	@GetMapping(path = "/testPage")
	public String testPage(){
				
			return "common/test";
	}
}
