package com.unla.TPObjetosII.converters;

import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.Cliente;
import com.unla.TPObjetosII.models.ClienteModel;


@Component("clienteConverter")
public class ClienteConverter {
	
	public ClienteModel entityToModel(Cliente cliente) {
		if (cliente==null) return null;
		return new ClienteModel(cliente.getIdPersona(), cliente.getApellido(), cliente.getNombre(), cliente.getFechaNacimiento(), cliente.getDni(), cliente.getEmail());
	}
	
	public Cliente modelToEntity(ClienteModel clienteModel) {
		if (clienteModel==null) return null;
		return new Cliente(clienteModel.getIdPersona() , clienteModel.getApellido(),clienteModel.getNombre(),clienteModel.getFechaNacimiento(),clienteModel.getDni(), clienteModel.getEmail());
	}

}
