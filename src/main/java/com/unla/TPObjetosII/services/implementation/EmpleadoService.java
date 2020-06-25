package com.unla.TPObjetosII.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.EmpleadoConverter;
import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.PedidoModel;
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
		return empleadoRepository.traerEmpleadosAlta();
	}
	
	@Override
	public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel) {
		Empleado empleado= empleadoRepository.save(empleadoConverter.modelToEntity(empleadoModel));
		return empleadoConverter.entityToModel(empleado);
	}
	
	@Override
	public boolean remove(int idEmpleado) {
		try {
			Empleado empleado=empleadoRepository.findByIdEmpleado(idEmpleado);
			empleado.setBaja(true);
			empleadoRepository.save(empleado);
		//	empleadoRepository.deleteById(idEmpleado);            aca era antes baja fisica
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<EmpleadoModel> traerEmpleadosPorIdDeLocal(int idLocal) {
		List<EmpleadoModel> empleados= new ArrayList<EmpleadoModel>();
		for(Empleado e: empleadoRepository.traerEmpleadosPorIdDeLocal(idLocal)) {
			empleados.add(empleadoConverter.entityToModel(e));
		}
		return empleados;
	}
	
	
	@Override
	public EmpleadoModel getEmpleado(int id) {
		return empleadoConverter.entityToModel(empleadoRepository.findByIdEmpleado(id));
	}

	@Override
	public EmpleadoModel getEmpleado(long dni) {
		return empleadoConverter.entityToModel(empleadoRepository.traerEmpleadoPorDni(dni));
	}
	

}
