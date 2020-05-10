package com.unla.TPObjetosII.converters;

import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.models.LocalModel;

@Component("localConverter")
public class LocalConverter {
	
	public LocalModel entityToModel(Local local) {
		return new LocalModel(local.getDireccion(),local.getLatitud(),local.getLongitud(), local.getTelefono());
	}
	
	public Local modelToEntity(LocalModel localModel) {
		return new Local(localModel.getDireccion(),localModel.getLatitud(),localModel.getLongitud(),localModel.getTelefono());
	}
}