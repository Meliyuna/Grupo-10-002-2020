package com.unla.TPObjetosII.controllers.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.services.IEmpleadoService;




@Controller
@RequestMapping("/api/empleado")
public class EmpleadoRestController {
	
	@Autowired	
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	
	@PostMapping("/alta")
	@ResponseBody
	public EmpleadoModel alta(@RequestBody EmpleadoModel empleado) throws Exception{  //RequestBody setea todos los atributos a empleado
		System.out.println(empleadoService.insertOrUpdate(empleado));
		return empleado;
	
	}
	
	@PostMapping("/traerEmpleados")
	@ResponseBody
	public List<Empleado> traerEmpleados() throws Exception{
		return empleadoService.getAll();
	}
	
	
	
	
}



