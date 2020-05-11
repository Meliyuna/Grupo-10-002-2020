package com.unla.TPObjetosII.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.EmpleadoConverter;
import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.repositories.IEmpleadoRepository;
import com.unla.TPObjetosII.services.IEmpleadoService;

@Service("empleadoService")
public class EmpleadoService implements IEmpleadoService {
	
	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository empleadoRepository;
	
	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;
	
	@Override
	public List<Empleado> getAll(){
		return empleadoRepository.findAllConLocal();
	}
	
	@Override
	public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel) {
		Empleado empleado= empleadoRepository.save(empleadoConverter.modelToEntity(empleadoModel));
		return empleadoConverter.entityToModel(empleado);
	}
	
	@Override
	public boolean remove(int idEmpleado) {
		try {
			empleadoRepository.deleteById(idEmpleado);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Empleado getEmpleado(int id) {
		Empleado e=empleadoRepository.findByIdEmpleado(id);
		return e;
	}
	

}
