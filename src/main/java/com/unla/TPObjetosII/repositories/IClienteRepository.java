package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Cliente;

@Repository("clienteRepository")
public interface IClienteRepository extends JpaRepository<Cliente, Serializable>{
	
	public abstract Cliente findByNombre(String nombre);
	public abstract Cliente findByDni(long dni);

// ejemplo de query para unir tablas. Persona tiene Numero
//	@Query("SELECT p from Persona p JOIN FETCH p.numeros where p.idPersona = (:id)")
//	public abstract Cliente findByIdFetchNumeros(@Param("id") int id);
}
