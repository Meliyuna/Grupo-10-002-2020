package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.models.EmpleadoModel;



@Repository ("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado, Serializable>{
	

	@Query("Select e from Empleado e LEFT JOIN FETCH e.local l where e.idPersona= (:idEmpleado) order by e.idPersona")
	public abstract Empleado findByIdEmpleado(int idEmpleado);
	
	@Query("Select e from Empleado e JOIN FETCH e.local l")
	public abstract List<Empleado> findAllConLocal();
	
	@Query("Select e from Empleado e where e.baja='0'")
	public abstract List<Empleado> traerEmpleadosAlta();   //empleados que tienen el estado alta en la bdd
	
	@Query("Select e from Empleado e where e.dni=(:dni) and e.baja='0'")
	public abstract Empleado traerEmpleadoPorDni(long dni);
	
	
	public abstract Empleado findByNombre(String nombre);
	

	@Query("select e from Empleado e join fetch e.local l where l.idLocal=(:idLocal) and e.baja='0'")
	public abstract List<Empleado> traerEmpleadosPorIdDeLocal(int idLocal);
}
