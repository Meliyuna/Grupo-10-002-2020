package com.unla.TPObjetosII.converters;

import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.Cliente;
import com.unla.TPObjetosII.models.ClienteModel;


@Component("clienteConverter")
public class ClienteConverter {
	
	public ClienteModel entityToModel(Cliente cliente) {
		return new ClienteModel(cliente.getApellido(), cliente.getNombre(), cliente.getFechaNacimiento(), cliente.getDni(), cliente.getEmail());
	}
	
	public Cliente modelToEntity(ClienteModel clienteModel) {
		return new Cliente(clienteModel.getApellido(),clienteModel.getNombre(),clienteModel.getFechaNacimiento(),clienteModel.getDni(), clienteModel.getEmail());
	}

}
