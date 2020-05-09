package com.unla.TPObjetosII.converters;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.LocalModel;


public class EmpleadoConverter {
	
	public EmpleadoModel entityToModel(Empleado empleado) {
		Local l=empleado.getLocal();
		LocalModel loc=new LocalModel(l.getDireccion(),l.getLatitud(),l.getLongitud(),l.getTelefono());
		return new EmpleadoModel(empleado.getApellido(),empleado.getNombre(),empleado.getFechaNacimiento(),empleado.getDni(),empleado.getFranjaHoraria(),empleado.isTipoEmpleado(),loc);
	}
	
	public Empleado modelToEntity(EmpleadoModel empleado) {
		LocalModel l=empleado.getLocal();
		Local loc= new Local(l.getDireccion(),l.getLatitud(),l.getLongitud(),l.getTelefono());
		return new Empleado(empleado.getApellido(),empleado.getNombre(),empleado.getFechaNacimiento(),empleado.getDni(),empleado.getFranjaHoraria(),empleado.isTipoEmpleado(),loc);
	}

}
