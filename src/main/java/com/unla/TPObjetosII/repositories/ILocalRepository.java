package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Local;

@Repository ("localRepository")
public interface ILocalRepository extends JpaRepository<Local, Serializable>{
	
	public abstract Local findByIdLocal(int idLocal);
	
	@Query("select l from Local l where l.telefono=(:telefono) and l.baja='0'")
	public abstract Local findByTelefono(double telefono);
	
	@Query("select l from Local l where l.baja='0'")
	public abstract List<Local> findAllLocal();
	
	@Query("select l from Local l join fetch l.listaLote lot join fetch lot.producto p where p.idProducto=(:idProducto) group by l having SUM(lot.cantidadActual)>0")
    public abstract List<Local> localesConStock(int idProducto);
}
