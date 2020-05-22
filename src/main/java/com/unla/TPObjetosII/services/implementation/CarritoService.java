package com.unla.TPObjetosII.services.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.CarritoConverter;
import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.repositories.ICarritoRepository;
import com.unla.TPObjetosII.services.ICarritoService;


@Service("carritoService")
public class CarritoService implements ICarritoService{

	
	@Autowired
	@Qualifier("carritoRepository")
	private ICarritoRepository carritoRepository;
	
	@Autowired
	@Qualifier("carritoConverter")
	private CarritoConverter carritoConverter;

	public CarritoModel insertOrUpdate(CarritoModel carritoModel) {				
		return carritoConverter.entityToModel(carritoRepository.save(carritoConverter.modelToEntity(carritoModel)));
	}

	
	public List<Carrito> getAll() {
		return carritoRepository.findAllConTodo();
	}
	
	
	public CarritoModel getById(int idCarrito) {
		return carritoConverter.entityToModel(carritoRepository.findByIdCarrito(idCarrito));
	}

	
//	public boolean remove(int idCarrito) {
//		try {
//			Carrito carrito=carritoRepository.findByIdCarrito(idCarrito);			
//			carritoRepository.save(carrito);
//			return true;
//		}catch(Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
	

}
