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
	public abstract Cliente findByDni(int dni);
	
	@Query("SELECT c from Cliente c")	
	public abstract List<Cliente> findAllConTodo();
}
