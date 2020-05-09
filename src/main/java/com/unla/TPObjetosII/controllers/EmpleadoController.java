package com.unla.TPObjetosII.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.TPObjetosII.services.IEmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	
	@GetMapping("")
	public String empleados(){
		return "/empleado/index";
		
	}
	
	@GetMapping("/empleado/{id}")
	public ModelAndView traerEmpleado(@PathVariable("id")int id){
		ModelAndView mv= new ModelAndView("empleado/id");
		mv.addObject("id",empleadoService.getEmpleado(id));
		return mv;
	}
	
	@GetMapping("/empleados/todos")
	public ModelAndView traerEmpleados() {
		ModelAndView mv=new ModelAndView("empleado/todos");
		mv.addObject("todos",empleadoService.getAll());
		return mv;
	}
	
	
	
	
}



