package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Cliente;
import com.unla.TPObjetosII.models.ClienteModel;

public interface IClienteService {
	
	public List<Cliente> getAll();
	public ClienteModel getById(int idCliente);
	public ClienteModel insertOrUpdate(ClienteModel clienteModel) throws Exception;
	public boolean remove(int idCliente);
	ClienteModel getByDni(int dni);

}
