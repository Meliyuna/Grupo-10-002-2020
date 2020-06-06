package com.unla.TPObjetosII.converters;

import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.models.LoteModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component ("loteConverter")
public class LoteConverter {
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
	public LoteModel entityToModel(Lote lote) {
		if(lote==null)return null;
		return new LoteModel(lote.getIdLote(),lote.getCantidadInicial(),lote.getCantidadActual(),lote.getFechaIngreso(),productoConverter.entityToModel(lote.getProducto()),lote.isEstado(),localConverter.entityToModel(lote.getLocal()));
	}

	public Lote modelToEntity(LoteModel loteModel) {
		if(loteModel==null)return null;
		return new Lote(loteModel.getIdLote(),loteModel.getCantidadInicial(),loteModel.getCantidadActual(),loteModel.getFechaIngreso(),productoConverter.modelToEntity(loteModel.getProducto()),loteModel.isEstado(),localConverter.modelToEntity(loteModel.getLocal()));
	}
}
