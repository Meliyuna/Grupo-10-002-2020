package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.models.SolicitudStockModel;

public interface ILocalService {
	
	public List<Local> getAll();
	public LocalModel insertOrUpdate(LocalModel localModel) throws Exception;
	public boolean remove(int idLocal);
	public LocalModel getById(int idLocal);
	public List<LocalModel> traerLocalesConDistancia(LocalModel local) throws Exception;
	public List<LocalModel> traerLocalesConStockDistanciaYCantidad(int idProducto,LocalModel local) throws Exception;
	public List<SolicitudStockModel> traerSolicitudesStock(LocalModel local);
	public SolicitudStockModel aceptarSolicitudStock(SolicitudStockModel solicitud,EmpleadoModel vendedorAux)throws Exception;
	public SolicitudStockModel negarSolicitudStock(SolicitudStockModel solicitud)throws Exception;
}
