package com.unla.TPObjetosII;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.TPObjetosII.repositories.IClienteRepository;

@SpringBootTest
class TpObjetosIiApplicationTests {

	@Autowired
	@Qualifier("clienteRepository")
	private IClienteRepository cRepo; //intanciar el repositorio
	
	@Test
	void contextLoads() {
		System.out.println(cRepo.findAll());
	}
	
	@Test
	void aksjghakg() {
		
	}

}
