package com.unla.TPObjetosII.controllers.api;
	
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.repositories.IEmpleadoRepository;
import com.unla.TPObjetosII.services.IEmpleadoService;
import com.unla.TPObjetosII.services.implementation.EmpleadoService;
	
	@RestController
	public class UsuarioController {
		
		@Autowired
		@Qualifier("empleadoRepository")
		private IEmpleadoRepository empleadoRepository;
	
		@Autowired
		private BCryptPasswordEncoder bCryptPasswordEncoder;
	
		@GetMapping("/users/")
		public List<Empleado> getAllUsuarios() {
			return empleadoRepository.findAll();
		}
	
		@GetMapping("/users/{username}")
		public Empleado getUsuario(@PathVariable String username) {
			return empleadoRepository.findByNombre(username);
		}
	}