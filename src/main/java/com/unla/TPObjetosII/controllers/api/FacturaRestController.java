package com.unla.TPObjetosII.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unla.TPObjetosII.models.FacturaModel;
import com.unla.TPObjetosII.models.PedidoModel;
import com.unla.TPObjetosII.services.IFacturaService;

@RestController
@RequestMapping("/api/factura")
public class FacturaRestController {
	
	
	@Autowired
	@Qualifier("facturaService")
	private IFacturaService facturaService;
	
	
	@PostMapping("/traerFacturas")
	@ResponseBody
	public ArrayNode traerFacturas(@RequestBody ObjectNode o) throws Exception {
		int idLocal=o.get("idLocal").asInt();
		ObjectMapper mapper = new ObjectMapper(); //un objeto que me ayuda a mapear o crear el json
		ArrayNode facturasNode=mapper.createArrayNode();
		for(FacturaModel f: facturaService.traerFacturas(idLocal)) {
			ObjectNode facturaNode=mapper.valueToTree(f);
			ObjectNode carritoNode=mapper.valueToTree(f.getCarrito());
			ObjectNode clienteNode=mapper.valueToTree(f.getCliente());
			ObjectNode empleadoNode=mapper.valueToTree(f.getEmpleado());
			facturaNode.set("carrito", carritoNode);
			facturaNode.set("cliente", clienteNode);
			facturaNode.set("empleado", empleadoNode);
			facturasNode.add(facturaNode);
		}
		return facturasNode;
	}
	
	@PostMapping("/verFacturaDetalle")
	@ResponseBody
	public ObjectNode verFacturaDetalle(@RequestBody ObjectNode o) throws Exception {
		int idFactura=o.get("idFactura").asInt();
		FacturaModel f=facturaService.verFacturaDetalle(idFactura);
		ObjectMapper mapper = new ObjectMapper(); //un objeto que me ayuda a mapear o crear el json
		ObjectNode facturaNode=mapper.valueToTree(f);
		ObjectNode carritoNode=mapper.valueToTree(f.getCarrito());
		ObjectNode clienteNode=mapper.valueToTree(f.getCliente());
		ObjectNode empleadoNode=mapper.valueToTree(f.getEmpleado());
		ArrayNode pedidosNode=mapper.createArrayNode();
		for(PedidoModel p: f.getCarrito().getListaPedido()) {
			pedidosNode.add(mapper.valueToTree(p)); //por cada pedido que tenga la lista se agrega al arrayNode
		}
		carritoNode.set("listaPedido", pedidosNode);
		facturaNode.set("cliente", clienteNode);
		facturaNode.set("empleado", empleadoNode);
		facturaNode.set("carrito", carritoNode);
		return facturaNode;
	}
	

}
