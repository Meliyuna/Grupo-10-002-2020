package com.unla.TPObjetosII.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	
	@GetMapping("")
	public String index() {
		return "/factura/facturas";
	}

	@GetMapping("/vistaFacturas")
	public String facturas() {
		return "/factura/vistas/facturas";
	}
}
