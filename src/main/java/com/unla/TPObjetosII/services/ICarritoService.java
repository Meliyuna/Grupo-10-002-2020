package com.unla.TPObjetosII.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.models.ProductoModel;


public interface ICarritoService {
	
	public List<Carrito> getAll();
	public CarritoModel getById(int idCarrito);
	public CarritoModel insertOrUpdate(CarritoModel CarritoModel);
	public List<CarritoModel> getAll(int idLocal);
	public boolean remove(int idCarrito);
	
	public List<ProductoModel> carritosConPedidos();
	public List<ProductoModel> carritosConPedidos(int idLocal);
	public List<ProductoModel> carritosConPedidosEntreFechas(int idLocal, LocalDateTime desde, LocalDateTime hasta);

}
