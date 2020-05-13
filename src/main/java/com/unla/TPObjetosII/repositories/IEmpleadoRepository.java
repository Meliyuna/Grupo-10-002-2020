package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Empleado;



@Repository ("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado, Serializable>{
	

	@Query("Select e from Empleado e JOIN FETCH e.local l where e.idPersona= (:idEmpleado) order by e.idPersona")
	public abstract Empleado findByIdEmpleado(int idEmpleado);
	
	@Query("Select e from Empleado e JOIN FETCH e.local l")
	public abstract List<Empleado> findAllConLocal();
	
	
	public abstract Empleado findByNombre(String nombre);
	
	

}
