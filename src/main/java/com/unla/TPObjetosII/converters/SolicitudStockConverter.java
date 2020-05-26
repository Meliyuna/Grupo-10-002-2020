package com.unla.TPObjetosII.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.SolicitudStock;
import com.unla.TPObjetosII.models.SolicitudStockModel;

@Component ("solicitudStockConverter")
public class SolicitudStockConverter{
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
	public SolicitudStockModel entityToModel(SolicitudStock sol) {
		if(sol==null)return null;
		return new SolicitudStockModel(sol.getIdSolicitudStock(),sol.getFechaAbierta(),sol.getFechaCerrada(),sol.isAceptado(),sol.getPendiente(),pedidoConverter.entityToModel(sol.getPedido()),localConverter.entityToModel(sol.getLocal()));
	}
	
	
	public SolicitudStock modelToEntity(SolicitudStockModel sol) {
		if(sol==null)return null;
		return new SolicitudStock(sol.getIdSolicitudStock(),sol.getFechaAbierta(),sol.getFechaCerrada(),sol.isAceptado(),sol.getPendiente(),pedidoConverter.modelToEntity(sol.getPedido()),localConverter.modelToEntity(sol.getLocal()));
	}
	
	public SolicitudStockModel entityToModelSinPedido(SolicitudStock sol) {
		if(sol==null)return null;
		return new SolicitudStockModel(sol.getIdSolicitudStock(),sol.getFechaAbierta(),sol.getFechaCerrada(),sol.isAceptado(),sol.getPendiente(),null,localConverter.entityToModel(sol.getLocal()));
	}
}
