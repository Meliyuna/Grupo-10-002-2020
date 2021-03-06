package com.unla.TPObjetosII.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@GetMapping("")
	public String index() {
		return "/pedido/stock";
	}
	
	@GetMapping("/carritos")
	public String stock() {
		return "/pedido/carritos";
	}
	
	@GetMapping("/vistaCarritos")
	public String vistaStock() {
		return "/pedido/vistas/carritos";
	}

}
