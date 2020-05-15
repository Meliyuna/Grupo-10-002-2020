package com.unla.TPObjetosII.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")

public class ClienteController {
	
	@GetMapping("")
	public String index() {
		return "/cliente/index";
	}
	
	@GetMapping("alta")
	public String alta() {
		return "/cliente/alta";
	}	
	
	@GetMapping ("modificacion")
	public String modificacion() {
		return "/cliente/modificacion";
	}
	
	@GetMapping ("baja")
	public String baja() {
		return "/cliente/baja";
	}

}