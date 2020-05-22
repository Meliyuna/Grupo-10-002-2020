package com.unla.TPObjetosII.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.PedidoModel;
import com.unla.TPObjetosII.services.IPedidoService;


@RestController
@RequestMapping("/api/pedido")
public class PedidoRestController {
	
	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@PostMapping("/alta")
	@ResponseBody
	public PedidoModel alta (@RequestBody ObjectNode pedidoNode) throws Exception {
		ObjectMapper mapper = new ObjectMapper().disable(MapperFeature.USE_ANNOTATIONS);
		PedidoModel pedidoModel = mapper.treeToValue(pedidoNode, PedidoModel.class);
		System.out.println(pedidoModel.getProducto().getIdProducto());
		return pedidoService.insertOrUpdate(pedidoModel);
	}
	
	@PostMapping("/traerPedidos")
	@ResponseBody
	public List<Pedido> traerPedidos() throws Exception {
		return pedidoService.getAll();
	}
		
	@PostMapping("/traerPedido")
	@ResponseBody
	public PedidoModel traerPedido(@RequestBody ObjectNode o) throws Exception{
		System.out.println(o.get("idPedido").asInt());
		return pedidoService.getById(o.get("idPedido").asInt());
	}
	

}