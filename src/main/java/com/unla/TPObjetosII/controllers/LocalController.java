package com.unla.TPObjetosII.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
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
	@Secured("ROLE_EMPLEADO")
	public String alta() {
		return "/local/alta";
	}
	
	@GetMapping("/modificacion")
	public String modificacion(HttpServletRequest req){
		return "/local/modificar";
	}
	
	@GetMapping("/vistaAlta")
	public String vistaAlta() {
		return "/local/vistas/alta";
	}
	
	@GetMapping("/vistaModificacion")
	public String vistaModificacion(){
		return "/local/vistas/modificar";
	}
}
