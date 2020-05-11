package com.unla.TPObjetosII.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/local")
public class LocalController {
	
	@GetMapping("")
	public String index() {
		return "/local/index";
	}
	
	@GetMapping("/alta")
	public String alta() {
		return "/local/alta";
	}
}
