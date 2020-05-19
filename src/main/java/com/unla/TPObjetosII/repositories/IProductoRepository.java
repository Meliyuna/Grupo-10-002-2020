package com.unla.TPObjetosII.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unla.TPObjetosII.entities.Producto;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Serializable>{
		
	public abstract Producto findByNombre(String nombre);

	public abstract Producto findByIdProducto(int id);
}
