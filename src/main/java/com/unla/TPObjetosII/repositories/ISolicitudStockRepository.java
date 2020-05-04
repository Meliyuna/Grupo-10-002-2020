package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.unla.TPObjetosII.entities.SolicitudStock;

@Repository("solicitudStockRepository")
public interface ISolicitudStockRepository extends JpaRepository<SolicitudStock, Serializable>{

	@Query("SELECT s from SolicitudStock s JOIN FETCH  s.local l where l.idLocal = (:id)")
	public abstract List<SolicitudStock> solicitudesStockXlocal(@Param("id") int id);
}
