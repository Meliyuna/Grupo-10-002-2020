package com.unla.TPObjetosII.services.implementation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.CarritoConverter;
import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.repositories.ICarritoRepository;
import com.unla.TPObjetosII.services.ICarritoService;
import com.unla.TPObjetosII.services.ILoteService;


@Service("carritoService")
public class CarritoService implements ICarritoService{

	
	@Autowired
	@Qualifier("carritoRepository")
	private ICarritoRepository carritoRepository;
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("carritoConverter")
	private CarritoConverter carritoConverter;

	public CarritoModel insertOrUpdate(CarritoModel carritoModel) {				
		return carritoConverter.entityToModel(carritoRepository.save(carritoConverter.modelToEntity(carritoModel)));
	}

	
	public List<Carrito> getAll() {
		return carritoRepository.findAllConTodo();
	}
	
	public List<Carrito> getAll(int idLocal){
		return carritoRepository.findAllByIdLocal(idLocal); 
	}
	
	public CarritoModel getById(int idCarrito) {
		return carritoConverter.entityToModel(carritoRepository.findByIdCarrito(idCarrito));
	}

	
	public boolean remove(int idCarrito) {
		try {
			Carrito carrito=carritoRepository.findByIdCarrito(idCarrito);
			List<Pedido> pedidos = new ArrayList<Pedido>();
			for(Pedido p: carrito.getListaPedido()) {
				pedidos.add(p);
			}
			this.loteService.devolverStockPedidosCancelados(pedidos);
			carritoRepository.delete(carrito);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
