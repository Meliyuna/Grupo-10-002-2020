package com.unla.TPObjetosII.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.models.PedidoModel;

@Component("carritoConverter")
public class CarritoConverter {
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidosConverter;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
	
	@SuppressWarnings({ "unused"})
	public CarritoModel entityToModel(Carrito carrito) {
		if (carrito==null) return null;
		Set<Pedido> p = carrito.getListaPedido();
		Set<PedidoModel> np = new HashSet<PedidoModel>();
		
		for (Pedido ped: p) {
			np.add(pedidosConverter.entityToModelNoCarrito(ped));			
		}
		CarritoModel carritoModel = new CarritoModel(	carrito.getIdCarrito(), 
									np, 
									carrito.getFecha(), 
									carrito.getTotal(), 
									clienteConverter.entityToModel(carrito.getCliente()));
		carritoModel.setLocal(localConverter.entityToModel(carrito.getLocal()));
		return carritoModel;
	}
	
	@SuppressWarnings("unused")
	public Carrito modelToEntity(CarritoModel carritoModel) {
		if (carritoModel==null) return null;
		Set<PedidoModel> p = carritoModel.getListaPedido();
		Set<Pedido> np = new HashSet<Pedido>();;
		
		if(p!=null) {
			for (PedidoModel ped: p) {
				np.add(pedidosConverter.modelToEntity(ped));			
			}
		}
		Carrito carrito = new Carrito(	carritoModel.getIdCarrito(), 
									np,
									carritoModel.getFecha(), 
									carritoModel.getTotal(), 
									clienteConverter.modelToEntity(carritoModel.getCliente()));
		carrito.setLocal(localConverter.modelToEntity(carritoModel.getLocal()));
		return carrito;
	}

}
