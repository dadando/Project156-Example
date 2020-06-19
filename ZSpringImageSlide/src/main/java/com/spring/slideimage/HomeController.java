package com.spring.slideimage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home.me")
	public String home()throws Exception{
		
		return "page_1/home";
	}
	
}
