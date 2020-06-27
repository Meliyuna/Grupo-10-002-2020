package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.unla.TPObjetosII.entities.Empleado;

@Repository("sueldosRepository")
public interface ISueldosRepository extends JpaRepository<Empleado, Serializable>{
	//@Query("Select p.vendedorOriginal, o.nombre, o.apellido, sum(p.subtotal*0.05) from Pedido p JOIN FETCH p.vendedorOriginal o LEFT JOIN FETCH p.vendedorAuxiliar group by p.vendedorOriginal, o.nombre, o.apellido")
	//public abstract List<Empleado> traerSueldosEmpleados();

}