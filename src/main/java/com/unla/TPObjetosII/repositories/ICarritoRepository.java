package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.entities.Factura;

@Repository("carritoRepository")

	public interface ICarritoRepository extends JpaRepository<Carrito, Serializable>{

	@Query("SELECT c FROM Carrito c WHERE c.fecha=(:fecha)")
	public abstract Carrito findByFecha(LocalDate fecha);
	
	
	@Query("SELECT c FROM Carrito c  left join fetch c.listaPedido p WHERE c.idCarrito=(:idCarrito)")
	public abstract Carrito findByIdCarrito(int idCarrito);
	
	@Query("SELECT c FROM Carrito c join fetch c.local WHERE c.idCarrito=(:idCarrito)")
	public abstract Carrito findByIdCarritoFetchLocal(int idCarrito);
	
	@Query("select c from Carrito c join fetch c.listaPedido pedidos join fetch pedidos.producto p WHERE c.idCarrito=(:idCarrito)")
	public abstract Carrito findCarritoConTodo(int idCarrito);
	
	@Query("SELECT c from Carrito c ")	
	public abstract List<Carrito> findAllConTodo();
	
	@Query("select c from Carrito c join fetch c.local l left join fetch c.listaPedido p left join fetch p.solicitudStock where l.idLocal = (:idLocal)")
	public abstract Set<Carrito> findAllByIdLocal(int idLocal);
	
	
	
}
