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
import com.unla.TPObjetosII.models.PedidoModel;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	

}
