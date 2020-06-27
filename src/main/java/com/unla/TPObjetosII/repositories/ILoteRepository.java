package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.entities.Producto;

@Repository ("loteRepository")
public interface ILoteRepository extends JpaRepository<Lote, Serializable>{

	public abstract Lote findByIdLote(int id);
	
	@Query("select l from Lote l join fetch l.producto p where p.idProducto = (:id)")
	public abstract List<Lote> lotesXproducto(@Param("id") int id);
	
	
	@Query("select l from Lote l join fetch l.local loc where loc.idLocal = (:id)" )
	public abstract List<Lote> lotesXlocal(@Param("id") int id);
	
	@Query("select l from Lote l join fetch l.producto p join fetch l.local loc where p.idProducto = (:idProducto) and loc.idLocal = (:idLocal)" )
	public abstract List<Lote> lotesXproductoXlocal(@Param("idProducto")int idProducto, @Param("idLocal")int idLocal);
	
	@Query("select l from Lote l join fetch l.local loc where loc.idLocal=(:idLocal)")
	public abstract List<Lote> findAllPorLocal(int idLocal);
}
