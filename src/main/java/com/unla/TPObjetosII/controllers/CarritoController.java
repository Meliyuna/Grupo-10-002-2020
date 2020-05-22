package com.unla.TPObjetosII.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/carrito")
public class CarritoController {	
		
		@GetMapping("")
		public String index() {
			return "/carrito/index";
		}
		
		@GetMapping("alta")
		public String alta() {
			return "/carrito/alta";
		}	
		
		@GetMapping ("modificacion")
		public String modificacion() {
			return "/carrito/modificacion";
		}
		
		@GetMapping ("baja")
		public String baja() {
			return "/carrito/baja";
		}

}
