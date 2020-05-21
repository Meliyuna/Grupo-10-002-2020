package com.unla.TPObjetosII;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.models.ProductoModel;
import com.unla.TPObjetosII.repositories.IClienteRepository;
import com.unla.TPObjetosII.repositories.ILocalRepository;
import com.unla.TPObjetosII.repositories.ILoteRepository;
import com.unla.TPObjetosII.repositories.IProductoRepository;
import com.unla.TPObjetosII.repositories.ISolicitudStockRepository;
import com.unla.TPObjetosII.services.ILoteService;
import com.unla.TPObjetosII.services.IProductoService;

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
	
	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository locRepo;
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
//	@Test
//	void contextLoads() {
//		System.out.println(cRepo.findAll());
//	}
// tests claudio	
	@Test
	void testProducto() {
//		List<Producto>productos=pRepo.findAll();
//		System.out.println(productos);
		
//		LocalDate fecha= LocalDate.now();
//		pRepo.save(new Producto("zapatillas Nike Air Max","zapatillas para correr",3000,fecha));
//		System.out.println(pRepo.findByIdProducto(2));
	}
	

	@Test
	void testLote() {
	//	lRepo.save(new Lote(200,100,LocalDate.now(),pRepo.findByIdProducto(11),true,locRepo.findByIdLocal(8)));
	//	System.out.println(lRepo.lotesXlocal(8));
	//	System.out.println(lRepo.lotesXproducto(8));
	//	List<Lote> lotes= lRepo.lotesXproducto(8);
//		System.out.println(lotes.get(0).getProducto());
//		System.out.println(lotes);
	//	System.out.println(lRepo.lotesXproductoXlocal(8, 8)==null);
		System.out.println(loteService.ProductosXlocal(8));
		System.out.println(loteService.ProductoXlocal(11,8));
	}
//	@Test
//	void testSolicitudesStock() {
//		System.out.println(sRepo.solicitudesStockXlocal(1));
//		
//	}
//	
	
}
