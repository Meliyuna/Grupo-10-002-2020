package com.unla.TPObjetosII.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.ClienteConverter;
import com.unla.TPObjetosII.entities.Cliente;
import com.unla.TPObjetosII.models.ClienteModel;
import com.unla.TPObjetosII.repositories.IClienteRepository;
import com.unla.TPObjetosII.services.IClienteService;

@Service("clienteService")
public class ClienteService implements IClienteService{
	
	@Autowired
	@Qualifier("clienteRepository")
	private IClienteRepository clienteRepository;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;

	@Override
	public ClienteModel insertOrUpdate(ClienteModel clienteModel) {
		return clienteConverter.entityToModel(clienteRepository.save(clienteConverter.modelToEntity(clienteModel)));
	}

	@Override
	public List<Cliente> getAll() {
		return clienteRepository.findAllConTodo();
	}

	@Override
	public boolean remove(int idCliente) {
		try {
			clienteRepository.deleteById(idCliente);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
