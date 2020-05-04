package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Lote;

@Repository ("loteRepository")
public interface ILoteRepository extends JpaRepository<Lote, Serializable>{

	@Query("SELECT l from Lote l JOIN FETCH l.producto p where p.idProducto = (:id)")
	public abstract List<Lote> lotesXproducto(@Param("id") int id);
}
