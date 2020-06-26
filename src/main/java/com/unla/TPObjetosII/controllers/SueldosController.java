
package com.unla.TPObjetosII.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sueldos")
public class SueldosController {
	
	@GetMapping("")
	public String index() {
		return "/sueldos/sueldos";
	}
	
	@GetMapping("/vistaSueldos")
	public String vistaSueldos() {
		return "/sueldos/vistas/sueldos";
	}

}