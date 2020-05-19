package com.unla.TPObjetosII;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.models.ProductoModel;
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
// tests claudio	
	@Test
	void testProducto() {
		System.out.println(pRepo.findAll());
		LocalDate fecha= LocalDate.now();
		pRepo.save(new Producto("zapatillas Nike Air Max","zapatillas para correr",3000,fecha));
		System.out.println(pRepo.findByIdProducto(2));
	}
	

	@Test
	void testLote() {
		System.out.println(lRepo.lotesXproducto(1));
	}
	@Test
	void testSolicitudesStock() {
		System.out.println(sRepo.solicitudesStockXlocal(1));
		
	}
//	
	
}
