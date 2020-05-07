package com.unla.TPObjetosII;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.repositories.IEmpleadoRepository;
import com.unla.TPObjetosII.repositories.ILocalRepository;
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
	@Qualifier("localRepository")
	private ILocalRepository lRepo;
	
	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository eRepo;
	
	
	@Test
	void verEmpleadosGuille() {
		System.out.println(eRepo.findAllConLocal());
	}
	
	
	@Test
	void agregarEmpleadoGuille() {
		LocalDate fecha= LocalDate.of(1995,9,23);
		Local local=lRepo.findByIdLocal(2);
		eRepo.save(new Empleado("Lucas","Medrana",fecha,30123102,"tarde-noche",false,local));
		System.out.println(eRepo.findAllConLocal());
	}
	
	
	@Test
	void agregarProductoGuille() {
		LocalDate fecha= LocalDate.of(2019,5,23);
		prRepo.save(new Producto("Campera addidas","blanco y negro talla L",2750f,fecha));
		System.out.println(prRepo.findAll());
	}
	
	
	@Test
	void agregarPedido() {
		
		Producto p= prRepo.findByNombre("Zapatilla nike gris");
		Producto p2= prRepo.findByNombre("Campera addidas");
		Local l=lRepo.findByIdLocal(1);
		Empleado e=eRepo.findByIdEmpleado(1);
		Empleado e2=eRepo.findByIdEmpleado(3);
		pedRepo.save(new Pedido(p,100,l,e,null,100000,true));
		pedRepo.save(new Pedido(p2,150,l,e2,null,19500,true));
		System.out.println(pedRepo.findAllConTodo());
	}

}
