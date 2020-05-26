package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.models.LocalModel;

public interface ILocalService {
	
	public List<Local> getAll();
	public LocalModel insertOrUpdate(LocalModel localModel) throws Exception;
	public boolean remove(int idLocal);
	public LocalModel getById(int idLocal);
	public List<LocalModel> traerLocalesConDistancia(LocalModel local) throws Exception;
	public List<LocalModel> traerLocalesConStockDistanciaYCantidad(int idProducto,LocalModel local) throws Exception;
}
