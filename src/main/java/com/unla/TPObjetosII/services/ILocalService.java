package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.models.LocalModel;

public interface ILocalService {
	
	public List<Local> getAll();
	public LocalModel insertOrUpdate(LocalModel localModel) throws Exception;
	public boolean remove(int idLocal);
}
