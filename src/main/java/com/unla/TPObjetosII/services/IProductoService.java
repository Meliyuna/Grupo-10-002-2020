package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.models.ProductoModel;


public interface IProductoService {

	public List<Producto> getAll();
	public ProductoModel findByIdProducto(int id);
	public ProductoModel insertOrUpdate(ProductoModel productoModel);
	public Producto remove (int id);


}
