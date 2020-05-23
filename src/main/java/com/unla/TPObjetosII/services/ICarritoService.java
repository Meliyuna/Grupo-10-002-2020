package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.models.CarritoModel;


public interface ICarritoService {
	
	public List<Carrito> getAll();
	public CarritoModel getById(int idCarrito);
	public CarritoModel insertOrUpdate(CarritoModel CarritoModel);
	public List<Carrito> getAll(int idLocal);
	public boolean remove(int idCarrito);

}
