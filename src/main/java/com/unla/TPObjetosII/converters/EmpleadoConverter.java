package com.unla.TPObjetosII.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.LocalModel;

@Component("empleadoConverter")
public class EmpleadoConverter {
	
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
	public EmpleadoModel entityToModel(Empleado empleado) {
		if(empleado==null)return null;
		Local l=empleado.getLocal();
		//LocalModel loc=new LocalModel(l.getIdLocal(),l.getDireccion(),l.getLatitud(),l.getLongitud(),l.getTelefono());
		return new EmpleadoModel(empleado.getIdPersona(),empleado.getApellido(),empleado.getNombre(),empleado.getFechaNacimiento(),empleado.getDni(),empleado.getFranjaHoraria(),empleado.isTipoEmpleado(),localConverter.entityToModel(l));
	}
	
	public Empleado modelToEntity(EmpleadoModel empleado) {
		if(empleado==null)return null;
		LocalModel l=empleado.getLocal();
		//Local loc= new Local(l.getIdLocal(),l.getDireccion(),l.getLatitud(),l.getLongitud(),l.getTelefono());
		return new Empleado(empleado.getIdPersona(),empleado.getApellido(),empleado.getNombre(),empleado.getFechaNacimiento(),empleado.getDni(),empleado.getFranjaHoraria(),empleado.isTipoEmpleado(),localConverter.modelToEntity(l));
	}

}
