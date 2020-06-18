package com.unla.TPObjetosII.controllers.api;

import java.net.URISyntaxException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.models.ClienteModel;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.FacturaModel;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.models.PedidoModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.services.ICarritoService;
import com.unla.TPObjetosII.services.IClienteService;
import com.unla.TPObjetosII.services.IEmpleadoService;

@RestController
@RequestMapping("/api/carrito")

public class CarritoRestController {
	
	@Autowired
	@Qualifier("carritoService")
	private ICarritoService CarritoService;
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	@PostMapping("/alta")
	@ResponseBody
	public CarritoModel alta (@RequestBody ObjectNode carritoNode) throws Exception {
		ObjectMapper mapper = new ObjectMapper().disable(MapperFeature.USE_ANNOTATIONS);
		CarritoModel carritoModel = mapper.treeToValue(carritoNode, CarritoModel.class);
		return CarritoService.insertOrUpdate(carritoModel);
	}
	
	@PostMapping("/traerCarritos")
	@ResponseBody
	public List<CarritoModel> traerCarritos(@RequestBody ObjectNode o) throws Exception {
		return CarritoService.getAll(o.get("idLocal").asInt());
	}
	
	@PostMapping("/traerCarrito")
	@ResponseBody
	public CarritoModel traerCarrito(@RequestBody ObjectNode o) throws Exception{
		return CarritoService.getById(o.get("idCarrito").asInt());
	}
	
	@PostMapping("/traerListaPedidos")
	@ResponseBody
	public List<PedidoModel> traerListaPedidos(@RequestBody ObjectNode o) throws Exception{
		return CarritoService.getById(o.get("idCarrito").asInt()).getListaPedido();
	}
	
	@PostMapping("/baja")
	@ResponseBody
	public Boolean baja (@RequestBody ObjectNode o) throws Exception{
		if(CarritoService.remove(o.get("idCarrito").asInt())==false) throw new Exception("Error al eliminar el Carrito");
		return true;
	}
	
	@PostMapping("/mostrarFactura")
	@ResponseBody
	public ObjectNode mostrarFactura(@RequestBody ObjectNode o) throws Exception {
		ObjectMapper mapper = new ObjectMapper(); //un objeto que me ayuda a mapear o crear el json
		CarritoModel c= CarritoService.getByIdConTodo((o.get("idCarrito").asInt()));
		ObjectNode carritoNode=mapper.valueToTree(c);
		ArrayNode pedidosNode=mapper.createArrayNode();
		for(PedidoModel p: c.getListaPedido()) {
			pedidosNode.add(mapper.valueToTree(p)); //por cada pedido que tenga la lista se agrega al arrayNode
		}
		carritoNode.set("listaPedido", pedidosNode); 
		return carritoNode;
	}
	
	@PostMapping("/buscarCliente")
	@ResponseBody
	public ClienteModel buscarClientePorDni(@RequestBody ObjectNode o)throws Exception{
		ClienteModel c=clienteService.getByDni((o.get("dni").asInt()));
		System.out.println(o.get("dni").asInt());
		System.out.println(c);
		if(c==null)throw new Exception("El cliente no existe");
		return c;
	}
	
	@PostMapping("/altaCliente")
	@ResponseBody
	public ClienteModel altaCliente(@RequestBody ClienteModel cliente)throws Exception{
		return clienteService.insertOrUpdate(cliente);
	}
	
	@PostMapping("/traerEmpleado")
	@ResponseBody
	public EmpleadoModel traerEmpleado(@RequestBody ObjectNode o) {
		return empleadoService.getEmpleado(o.get("idEmpleado").asInt());
	}
	
	@PostMapping("/generarFactura")
	@ResponseBody
	public FacturaModel generarFactura(@RequestBody ObjectNode o) throws Exception {
		int idCarrito=o.get("idCarrito").asInt();
		int  idCliente=o.get("idCliente").asInt();
		int idEmpleado=o.get("idEmpleado").asInt();
		return CarritoService.generarFactura(idCarrito, idCliente, idEmpleado);
	}
	

}
