package com.unla.TPObjetosII;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.repositories.IEmpleadoRepository;
import com.unla.TPObjetosII.repositories.ILocalRepository;
import com.unla.TPObjetosII.repositories.ILoteRepository;
import com.unla.TPObjetosII.repositories.IPedidoRepository;
import com.unla.TPObjetosII.repositories.IProductoRepository;

@SpringBootTest
public class TPObjetosIITest2 {
	
	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedRepo; //instanciar el repositorio
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository prRepo;
	
	@Autowired
	@Qualifier("loteRepository")
	private ILoteRepository loteRepo;
	
	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository lRepo;
	
	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository eRepo;
	
	@Test
	void agregarLotes() {
		List<Producto> productos = prRepo.findAll();
		List<Local> locales = lRepo.findAll();
		for(Local l: locales) {
			for(Producto p:productos) {
				Random r = new Random(System.currentTimeMillis());
				int inicial = r.nextInt(100);
				if(inicial==0)inicial=1;
				int actual = r.nextInt(inicial);
				Lote lote = new Lote(inicial,actual, LocalDate.now(), p,true,l);
				loteRepo.save(lote);
			}
		}
	}

}
