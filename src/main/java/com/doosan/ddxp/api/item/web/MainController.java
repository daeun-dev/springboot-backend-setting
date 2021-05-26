package com.doosan.ddxp.api.item.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@ResponseBody
	@GetMapping("/main")
	public String test() {

		
	System.out.println("MainMainMainMainMain");

	return "Main";
	}
}

