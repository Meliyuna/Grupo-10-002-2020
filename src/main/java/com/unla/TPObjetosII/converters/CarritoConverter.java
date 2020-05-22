package com.unla.TPObjetosII.converters;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.models.PedidoModel;

@Component("carritoConverter")
public class CarritoConverter {
	
	PedidoConverter pedidosConverter;
	ClienteConverter clienteConverter;
	
	
	@SuppressWarnings({ "unused", "null" })
	public CarritoModel entityToModel(Carrito carrito) {
		Set<Pedido> p = carrito.getListaPedido();
		Set<PedidoModel> np = null;
		
		for (Pedido ped: p) {
			np.add(pedidosConverter.entityToModel(ped));			
		}
		
		if (carrito==null) return null;
		return new CarritoModel(	carrito.getIdCarrito(), 
									np, 
									carrito.getFecha(), 
									carrito.getTotal(), 
									clienteConverter.entityToModel(carrito.getCliente()));
	}
	
	@SuppressWarnings("unused")
	public Carrito modelToEntity(CarritoModel carritoModel) {
		Set<PedidoModel> p = carritoModel.getListaPedido();
		Set<Pedido> np = null;
		
		for (PedidoModel ped: p) {
			np.add(pedidosConverter.modelToEntity(ped));			
		}
		
		if (carritoModel==null) return null;
		return new Carrito(	carritoModel.getIdCarrito(), 
									np, 
									carritoModel.getFecha(), 
									carritoModel.getTotal(), 
									clienteConverter.modelToEntity(carritoModel.getCliente()));
	}

}
