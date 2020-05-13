package com.unla.TPObjetosII.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	
	
	@GetMapping("")
	public String empleados(){
		return "/empleado/index";
		
	}
	
	@GetMapping("/alta")
	public String alta() {
		return "/empleado/alta";
	}
	
	
	@GetMapping("/modificar")
	public String modificacion() {
		return "/empleado/modificar";
	}

	
	
	
}



