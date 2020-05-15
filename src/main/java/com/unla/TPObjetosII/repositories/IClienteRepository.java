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
	
	@Query("SELECT c FROM Cliente c WHERE c.baja='0' and c.nombre=(:nombre)")
	public abstract Cliente findByNombre(String nombre);
	
	@Query("SELECT c FROM Cliente c WHERE c.baja='0' and c.dni=(:DNI)")
	public abstract Cliente findByDni(long DNI);
	
	@Query("SELECT c FROM Cliente c WHERE c.baja='0' and c.idPersona=(:idPersona)")
	public abstract Cliente findByIdPersona(int idPersona);
	
	@Query("SELECT c from Cliente c WHERE c.baja='0'")	
	public abstract List<Cliente> findAllConTodo();
	
	
}
