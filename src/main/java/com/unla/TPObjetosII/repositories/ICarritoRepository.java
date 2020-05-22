package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Carrito;

@Repository("carritoRepository")

	public interface ICarritoRepository extends JpaRepository<Carrito, Serializable>{

	@Query("SELECT c FROM Carrito c WHERE c.fecha=(:fecha)")
	public abstract Carrito findByFecha(LocalDate fecha);
	
	
	@Query("SELECT c FROM Carrito c WHERE c.idCarrito=(:idCarrito)")
	public abstract Carrito findByIdCarrito(int idCarrito);
	
	@Query("SELECT c from Carrito c ")	
	public abstract List<Carrito> findAllConTodo();
	
}
