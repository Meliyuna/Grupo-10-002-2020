package com.unla.TPObjetosII.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.Pedido;

import com.unla.TPObjetosII.models.PedidoModel;

@Component("pedidoConverter")
public class PedidoConverter {
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;
	
	@Autowired
	@Qualifier("carritoConverter")
	private CarritoConverter carritoConverter;
	
	@Autowired
	@Qualifier("solicitudStockConverter")
	private SolicitudStockConverter solicitudStockConverter;

	public Pedido modelToEntity(PedidoModel pedidoModel) {		
		if (pedidoModel==null) return null;
		return new Pedido(	pedidoModel.getIdPedido(), 
							productoConverter.modelToEntity(pedidoModel.getProducto()),
							pedidoModel.getCantidad(),
							empleadoConverter.modelToEntity(pedidoModel.getVendedorOriginal()), 
							empleadoConverter.modelToEntity(pedidoModel.getVendedorAuxiliar()), 
							carritoConverter.modelToEntity(pedidoModel.getCarrito()),
							pedidoModel.getSubtotal(), 
							pedidoModel.isAceptado(),
							solicitudStockConverter.modelToEntity(pedidoModel.getSolicitudStock())
						);		
		
	}
	
	public PedidoModel entityToModel(Pedido pedido) {
		if (pedido==null) return null;
		return new PedidoModel(	pedido.getIdPedido(), 
							productoConverter.entityToModel(pedido.getProducto()),
							pedido.getCantidad(),
							empleadoConverter.entityToModel(pedido.getVendedorOriginal()), 
							empleadoConverter.entityToModel(pedido.getVendedorAuxiliar()), 
							carritoConverter.entityToModel(pedido.getCarrito()),
							pedido.getSubtotal(), 
							pedido.isAceptado(),
							solicitudStockConverter.entityToModelSinPedido(pedido.getSolicitudStock())
						);
	}
	
	public PedidoModel entityToModelNoCarrito(Pedido pedido) {
		if (pedido==null) return null;
		return new PedidoModel(	pedido.getIdPedido(), 
							productoConverter.entityToModel(pedido.getProducto()),
							pedido.getCantidad(),
							empleadoConverter.entityToModel(pedido.getVendedorOriginal()), 
							empleadoConverter.entityToModel(pedido.getVendedorAuxiliar()), 
							null,
							pedido.getSubtotal(), 
							pedido.isAceptado(),
							solicitudStockConverter.entityToModelSinPedido(pedido.getSolicitudStock())
						);
	}
}

