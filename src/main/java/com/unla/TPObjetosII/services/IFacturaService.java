package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.models.FacturaModel;

public interface IFacturaService {
	
	public List<FacturaModel> traerFacturas(int idLocal);

}
