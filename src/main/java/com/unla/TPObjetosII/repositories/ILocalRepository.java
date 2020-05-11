package com.unla.TPObjetosII.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Local;

@Repository ("localRepository")
public interface ILocalRepository extends JpaRepository<Local, Serializable>{
	
	public abstract Local findByIdLocal(int idLocal);
	public abstract Local findByTelefono(double telefono);
	
}
