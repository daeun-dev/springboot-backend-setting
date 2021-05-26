package com.doosan.ddxp.api.item.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doosan.ddxp.api.core.exception.BadRequestException;

@Controller
public class TestController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	//private ItemService itemService;
	
	@ResponseBody
	@GetMapping("/test")
	public String test() {
//		Logger logger = LoggerFactory.getLogger(TestController.class);
		
		System.out.println("TESTTESTDDXP!!!1");
		
//		List<Item> itemList = itemService.getItemList();
//		int size = itemList.size();
//		logger.info(String.valueOf(size));
		return "DDXP TEST!!!";
	}
	
	@ResponseBody
	@GetMapping("/test-internationalized")
	public String testInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("test.message", null, locale);
	}
	
	@ResponseBody
	@GetMapping("/errorPage")
	public void errorTest() throws Exception {
				
			throw new BadRequestException("badRequest!!");
	}
	
	@GetMapping("/testPage")
	public String testPage(){
				
			return "common/test";
	}
}
