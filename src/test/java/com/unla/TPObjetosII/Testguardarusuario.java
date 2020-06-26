package com.unla.TPObjetosII;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.entities.Usuario;
import com.unla.TPObjetosII.repositories.IEmpleadoRepository;
import com.unla.TPObjetosII.repositories.IUsuarioRepository;

@SpringBootTest
class Testguardarusuario {

	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository empleadoRepository;
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void test() {
		List<Usuario> us = usuarioRepository.findAllConEmpleado();
		for(Usuario u: us) {
			Empleado e = u.getEmpleado();
			u.setUsername(String.valueOf(e.getDni()));
			usuarioRepository.save(u);
		}
	}

}
