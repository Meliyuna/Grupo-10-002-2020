package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Cliente;
import com.unla.TPObjetosII.entities.Producto;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Serializable>{
	
	@Query("select p from Producto p where p.nombre=(:nombre) and p.baja='0'")
	public abstract Producto findByNombre(String nombre);

	public abstract Producto findByIdProducto(int id);
	
	@Query("select p from Producto p where p.baja='0'")
	public abstract List<Producto> findAll();
	
}
