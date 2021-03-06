package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.entities.SolicitudStock;

@Repository ("localRepository")
public interface ILocalRepository extends JpaRepository<Local, Serializable>{
	
	public abstract Local findByIdLocal(int idLocal);
	
	@Query("select l from Local l where l.telefono=(:telefono) and l.baja='0'")
	public abstract Local findByTelefono(double telefono);
	
	@Query("select l from Local l where l.baja='0'")
	public abstract List<Local> findAllLocal();
	
	@Query("select l from Local l join fetch l.listaLote lot join fetch lot.producto p where p.idProducto=(:idProducto) group by l having SUM(lot.cantidadActual)>0")
    public abstract List<Local> localesConStock(int idProducto);
	
	@Query("select l from Local l left join fetch l.listaSolicitudStock sol join fetch sol.pedido pe join fetch pe.producto join fetch pe.carrito ca join fetch ca.local where l.idLocal=(:idLocal) and sol.pendiente='1' and pe.baja='0'")
	public abstract Local traerSolicitudesStock(int idLocal);

}
