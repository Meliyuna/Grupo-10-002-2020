package com.unla.TPObjetosII.converters;

import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.models.PedidoModel;
import com.unla.TPObjetosII.models.ProductoModel;
import com.unla.TPObjetosII.converters.ProductoConverter;

import java.util.Set;

import com.unla.TPObjetosII.converters.EmpleadoConverter;

public class PedidoConverter {
	
	ProductoConverter productoConverter = new ProductoConverter();
	EmpleadoConverter empleadoConverter = new EmpleadoConverter();

	public Pedido modelToEntity(PedidoModel pedidoModel) {
			
	
		
		
		if (pedidoModel==null) return null;
		return new Pedido(	pedidoModel.getIdPedido(), 
							productoConverter.modelToEntity(pedidoModel.getProducto()),
							pedidoModel.getCantidad(),
							empleadoConverter.modelToEntity(pedidoModel.getVendedorOriginal()), 
							empleadoConverter.modelToEntity(pedidoModel.getVendedorAuxiliar()), 
							pedidoModel.getSubtotal(), 
							pedidoModel.isAceptado()
						);		
		
	}
	
	public PedidoModel entityToModel(Pedido pedido) {
		
		if (pedido==null) return null;
		return new PedidoModel(	pedido.getIdPedido(), 
							productoConverter.entityToModel(pedido.getProducto()),
							pedido.getCantidad(),
							empleadoConverter.entityToModel(pedido.getVendedorOriginal()), 
							empleadoConverter.entityToModel(pedido.getVendedorAuxiliar()), 
							pedido.getSubtotal(), 
							pedido.isAceptado()
						);
	}
}

