package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

	@Query("SELECT c FROM Carrito c WHERE c.fecha=(:fecha) and c.baja='0'")
	public abstract Carrito findByFecha(LocalDate fecha);
	
	
	@Query("SELECT c FROM Carrito c left join fetch c.listaPedido p WHERE c.idCarrito=(:idCarrito) and c.baja='0'")
	public abstract Carrito findByIdCarrito(int idCarrito);
	
	@Query("SELECT c FROM Carrito c join fetch c.local WHERE c.idCarrito=(:idCarrito) and c.baja='0'")
	public abstract Carrito findByIdCarritoFetchLocal(int idCarrito);
	
	@Query("select c from Carrito c join fetch c.listaPedido pedidos join fetch pedidos.producto p WHERE c.idCarrito=(:idCarrito) and c.baja='0' and (pedidos is NULL or pedidos.baja='0')")
	public abstract Carrito findCarritoConTodo(int idCarrito);
	
	@Query("SELECT c from Carrito c where c.baja='0'")	
	public abstract List<Carrito> findAllConTodo();
	
	@Query("SELECT c from Carrito c join fetch c.factura f where c.baja='0' and f is not null")	
	public abstract List<Carrito> findAllFacturados();
	
	@Query("select c from Carrito c join fetch c.local l left join fetch c.listaPedido p left join fetch p.solicitudStock left join fetch c.factura f "
			+ "where l.idLocal = (:idLocal) and c.baja='0' and f is NULL order by c.idCarrito")
	public abstract Set<Carrito> findAllByIdLocalSinFacturar(int idLocal);
	
	
	
	@Query("SELECT c from Carrito c join fetch c.local lo join fetch c.factura f where lo.idLocal = (:idLocal) and f is not null")	
	public abstract List<Carrito> findAllFacturados(int idLocal);
	
	@Query("SELECT c from Carrito c join fetch c.local lo join fetch c.factura f where lo.idLocal = (:idLocal) and f is not null and f.fechaFacturado BETWEEN (:fechaDesde) and (:fechaHasta) ")	
	public abstract List<Carrito> findAllFacturadosEntreFechas(int idLocal, LocalDateTime fechaDesde, LocalDateTime fechaHasta);
}
