package com.unla.TPObjetosII;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.TPObjetosII.repositories.IClienteRepository;
import com.unla.TPObjetosII.repositories.ILoteRepository;
import com.unla.TPObjetosII.repositories.IProductoRepository;
import com.unla.TPObjetosII.repositories.ISolicitudStockRepository;

@SpringBootTest
class TpObjetosIiApplicationTests {

	@Autowired
	@Qualifier("clienteRepository")
	private IClienteRepository cRepo; //intanciar el repositorio
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository pRepo;
	
	@Autowired
	@Qualifier("loteRepository")
	private ILoteRepository lRepo;
	
	@Autowired
	@Qualifier("solicitudStockRepository")
	private ISolicitudStockRepository sRepo;
	
	@Test
	void contextLoads() {
		System.out.println(cRepo.findAll());
	}
	
	@Test
	void testProductoClaudio() {
		System.out.println(pRepo.findAll());
	}
	@Test
	void testLoteClaudio() {
		System.out.println(lRepo.lotesXproducto(1));
	}
	@Test
	void testSolicitudesStockClaudio() {
		System.out.println(sRepo.solicitudesStockXlocal(1));
	}
	
	
}
