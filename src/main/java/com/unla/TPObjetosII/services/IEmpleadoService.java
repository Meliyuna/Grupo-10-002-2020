package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.models.EmpleadoModel;

public interface IEmpleadoService {
	
	public EmpleadoModel getEmpleado(int id);

	public List<Empleado> getAll();
	
	public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel);
	
	public boolean remove(int idEmpleado);
	
	public EmpleadoModel getEmpleado(long dni);
	
	public List<EmpleadoModel> traerEmpleadosPorIdDeLocal(int idLocal);
}
