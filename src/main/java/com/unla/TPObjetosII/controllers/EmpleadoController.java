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

	@GetMapping("/baja")
	public String baja() {
		return "/empleado/baja";
	}
	
	
	@GetMapping("/vistaAlta")
	public String vistaAlta() {
		return "/empleado/vistas/alta";
	}
	
	@GetMapping("/vistaModificacion")
	public String vistaModificacion(){
		return "/empleado/vistas/modificar";
	}
	
	@GetMapping("/vistaBaja")
	public String vistaBaja(){
		return "/empleado/vistas/baja";
	}
	
}



