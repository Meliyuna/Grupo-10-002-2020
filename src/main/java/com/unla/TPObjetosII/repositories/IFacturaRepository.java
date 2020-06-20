package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Factura;

@Repository ("facturaRepository")
public interface IFacturaRepository extends JpaRepository<Factura, Serializable>{
	
	@Query("select f from Factura f where f.idFactura=(:idFactura)")
	public abstract Factura findByIdFactura(int idFactura);
	
	@Query("select f from Factura f join fetch f.carrito c  where f.idFactura=(:idFactura)")
	public abstract Factura findByIdFacturaFetchYCarrito(int idFactura);

	@Query("SELECT f FROM Factura f join fetch f.carrito c join fetch c.local l")
	public abstract List<Factura> traerFacturas();
	
	@Query("select f from Factura f join fetch f.carrito carr join fetch carr.listaPedido p join fetch carr.local l join fetch f.empleado e join fetch f.cliente cli")
	public abstract List<Factura> findAllConTodo();
	
	@Query("select f from Factura f join fetch f.carrito carr join fetch carr.listaPedido pedidos join fetch pedidos.producto p join fetch f.empleado e join fetch f.cliente c where f.idFactura=(:idFactura)")
	public abstract Factura findByIdFacturaConTodo(int idFactura);
}
