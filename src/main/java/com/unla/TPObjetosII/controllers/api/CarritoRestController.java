package com.unla.TPObjetosII.controllers.api;

import java.net.URISyntaxException;
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
import com.unla.TPObjetosII.services.ICarritoService;

@RestController
@RequestMapping("/api/carrito")

public class CarritoRestController {
	
	@Autowired
	@Qualifier("carritoService")
	private ICarritoService CarritoService;
	
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
	public Set<PedidoModel> traerListaPedidos(@RequestBody ObjectNode o) throws Exception{
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
	
	@PostMapping("/generarfactura")
	@ResponseBody
	public FacturaModel generarFactura(@RequestBody ObjectNode facturaNode) throws Exception {
		ObjectMapper mapper = new ObjectMapper(); //un objeto que me ayuda a mapear o crear el json
		FacturaModel f= mapper.treeToValue(facturaNode, FacturaModel.class);	//convierte el object node a facturaModel
		int idCarrito=facturaNode.get("idCarrito").asInt();
		f.setCarrito(CarritoService.getById(idCarrito));
		return CarritoService.generarFactura(f.getIdFactura());
	}
	

}
