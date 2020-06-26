package com.unla.TPObjetosII.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.models.FacturaModel;
import com.unla.TPObjetosII.models.ProductoModel;


public interface ICarritoService {
	
	public List<Carrito> getAll();
	public CarritoModel getById(int idCarrito);
	public CarritoModel insertOrUpdate(CarritoModel CarritoModel);
	public List<CarritoModel> getAllSinFacturar(int idLocal);
	public boolean remove(int idCarrito);
	public FacturaModel generarFactura(int idCarrito, int idCliente, int idEmpleado) throws Exception;
	public CarritoModel getByIdConTodo(int idCarrito);
	
	
	public List<ProductoModel> carritosFacturadosConPedidos();
	public List<ProductoModel> carritosFacturadosConPedidos(int idLocal);
	public List<ProductoModel> carritosConPedidosEntreFechas(int idLocal, LocalDateTime desde, LocalDateTime hasta);

}
