package com.unla.TPObjetosII.controllers.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.services.IEmpleadoService;




@Controller
@RequestMapping("/api/empleado")
public class EmpleadoRestController {
	
	@Autowired	
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	
	@PostMapping("/alta")
	public ResponseEntity<EmpleadoModel> alta(@RequestBody EmpleadoModel empleado){  //RequestBody setea todos los atributos a empleado
		System.out.println(empleadoService.insertOrUpdate(empleado));
		return ResponseEntity.ok(empleado);
	
	}
	
	
	
	
	
}



