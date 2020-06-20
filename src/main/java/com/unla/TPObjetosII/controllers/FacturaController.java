package com.unla.TPObjetosII.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facturas")
public class FacturaController {
	
	@GetMapping("")
	public String index() {
		return "/facturas/facturas";
	}

	@GetMapping("/vistaFacturas")
	public String facturas() {
		return "/facturas/vistas/facturas";
	}
}
