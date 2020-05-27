package com.unla.TPObjetosII.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.unla.TPObjetosII.converters.SolicitudStockConverter;
import com.unla.TPObjetosII.entities.SolicitudStock;
import com.unla.TPObjetosII.models.SolicitudStockModel;
import com.unla.TPObjetosII.repositories.ISolicitudStockRepository;
import com.unla.TPObjetosII.services.ISolicitudStockService;

public class SolicitudStockService implements ISolicitudStockService {

	@Autowired
	@Qualifier("solicitudStockConverter")
	private SolicitudStockConverter solicitudStockConverter;
	
	@Autowired
	@Qualifier("solicitudStockRepository")
	private ISolicitudStockRepository solicitudStockRepository;
	
	@Override
	public SolicitudStockModel getById(int idSolicitudStock) {
		SolicitudStock s=solicitudStockRepository.findByIdSolicitudStock(idSolicitudStock);
		return solicitudStockConverter.entityToModel(s);
	}

}
