package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Factura;
import com.unla.TPObjetosII.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{

	@Query("Select u from Usuario u join fetch u.empleado e where u.username=(:username) and e.baja='0'")
	public abstract Usuario findByUsername(String username);
	
	@Query("Select u from Usuario u join fetch u.empleado e where e.baja='0'")
	public abstract List<Usuario> findAllConEmpleado();
}
