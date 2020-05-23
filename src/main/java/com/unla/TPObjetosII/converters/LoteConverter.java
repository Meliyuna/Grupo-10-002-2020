package com.unla.TPObjetosII.converters;

import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.models.LoteModel;

import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.converters.ProductoConverter;
import com.unla.TPObjetosII.converters.LocalConverter;

@Component ("loteConverter")
public class LoteConverter {
	ProductoConverter productoConverter;
	LocalConverter localConverter;
	
	public LoteModel entityToModel(Lote lote) {
		return new LoteModel(lote.getIdLote(),lote.getCantidadInicial(),lote.getCantidadActual(),lote.getFechaIngreso(),productoConverter.entityToModel(lote.getProducto()),lote.isEstado(),localConverter.entityToModel(lote.getLocal()));
	}

	public Lote modelToEntity(LoteModel loteModel) {
		return new Lote(loteModel.getIdLote(),loteModel.getCantidadInicial(),loteModel.getCantidadActual(),loteModel.getFechaIngreso(),productoConverter.modelToEntity(loteModel.getProducto()),loteModel.isEstado(),localConverter.modelToEntity(loteModel.getLocal()));
	}
}
