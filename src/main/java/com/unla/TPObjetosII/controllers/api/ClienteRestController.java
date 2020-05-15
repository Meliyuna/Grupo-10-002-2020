package com.unla.TPObjetosII.controllers.api;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unla.TPObjetosII.models.ClienteModel;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unla.TPObjetosII.entities.Cliente;
import com.unla.TPObjetosII.services.IClienteService;

@RestController
@RequestMapping("/api/cliente")

public class ClienteRestController {
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@PostMapping("/alta")
	@ResponseBody
	public ClienteModel alta (@RequestBody ClienteModel cliente) throws Exception {
		System.out.println(clienteService.insertOrUpdate(cliente));
		return cliente;
	}
	
	@PostMapping("/traerClientes")
	@ResponseBody
	public List<Cliente> traerClientes() throws Exception {
		return clienteService.getAll();
	}
	
	@PostMapping("/traerCliente")
	@ResponseBody
	public ClienteModel traerCliente(@RequestBody ObjectNode o) throws Exception{
		System.out.println(o.get("idPersona").asInt());
		return clienteService.getById(o.get("idPersona").asInt());
	}
	
	@PostMapping("/baja")
	@ResponseBody
	public Boolean baja (@RequestBody ObjectNode o) throws Exception{
		System.out.println(o.get("idPersona").asInt());
		if(clienteService.remove(o.get("idPersona").asInt())==false) throw new Exception("Error al eliminar el Cliente");
		return true;
	}
	
	

}
