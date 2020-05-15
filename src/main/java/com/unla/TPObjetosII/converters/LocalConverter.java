package com.unla.TPObjetosII.converters;

import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.models.LocalModel;

@Component("localConverter")
public class LocalConverter {
	
	public LocalModel entityToModel(Local local) {
		if (local==null)return null;
		return new LocalModel(local.getIdLocal(),local.getDireccion(),local.getLatitud(),local.getLongitud(), local.getTelefono());
	}
	
	public Local modelToEntity(LocalModel localModel) {
		if (localModel==null)return null;
		return new Local(localModel.getIdLocal(),localModel.getDireccion(),localModel.getLatitud(),localModel.getLongitud(),localModel.getTelefono());
	}
}