package com.unla.TPObjetosII;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.entities.Usuario;
import com.unla.TPObjetosII.repositories.IEmpleadoRepository;
import com.unla.TPObjetosII.repositories.ILocalRepository;
import com.unla.TPObjetosII.repositories.IUsuarioRepository;

@SpringBootTest
class Testguardarusuario {

	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository empleadoRepository;
	
	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository localRepository;
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void test() {
		Empleado e = new Empleado();
		e.setApellido("Gutierrez");
		e.setNombre("Jose");
		e.setDni(24543643);
		e.setFechaNacimiento(LocalDate.now());
		e.setTipoEmpleado(true);
		e.setFranjaHoraria("Noche");
		e.setLocal(localRepository.findByIdLocal(1));
		e = empleadoRepository.save(e);
		Usuario u = new Usuario();
		u.setUsername(String.valueOf(e.getDni()));
		u.setPassword(encoder.encode("123"));
		u.setEmpleado(e);
		usuarioRepository.save(u);
	}

}
