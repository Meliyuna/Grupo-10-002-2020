package com.unla.TPObjetosII;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.repositories.IEmpleadoRepository;

@SpringBootTest
class Testguardarusuario {

	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository empleadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void test() {
		Empleado e = empleadoRepository.findByNombre("Marcelo");
		e.setPassword(encoder.encode("123"));
		System.out.println(e.getPassword());
		empleadoRepository.save(e);
	}

}
