package com.unla.TPObjetosII.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.FacturaConverter;
import com.unla.TPObjetosII.entities.Factura;
import com.unla.TPObjetosII.models.FacturaModel;
import com.unla.TPObjetosII.repositories.IFacturaRepository;
import com.unla.TPObjetosII.services.IFacturaService;

@Service("facturaService")
public class FacturaService implements IFacturaService{

	@Autowired
	@Qualifier("facturaRepository")
	private IFacturaRepository facturaRepository;
	
	@Autowired
	@Qualifier("facturaConverter")
	private FacturaConverter facturaConverter;
	
	
	@Override
	public List<FacturaModel> traerFacturas(int idLocal) {
		List<Factura> f =facturaRepository.findAllConTodo();
		List<FacturaModel> facturas =new ArrayList<FacturaModel>();
		for (Factura i : f) {
			if (i.getCarrito().getLocal().getIdLocal() == idLocal) {
				facturas.add(facturaConverter.entityToModel(i));
			}
		}
		return facturas;
	}

}
