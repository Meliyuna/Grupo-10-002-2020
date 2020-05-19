package com.unla.TPObjetosII.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
	
	@GetMapping("")
	public String home(){
		return "/index";
	}
	
	@GetMapping("/estructura")
	public String bootstrap() {
		return "estructura/estructura";
	}
	
	@GetMapping("/blank")
	public String bootstrapBlank() {
		return "bootstrap/blank";
	}
	
}
