package com.unla.TPObjetosII.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.models.ProductoModel;
import com.unla.TPObjetosII.services.IClienteService;
import com.unla.TPObjetosII.services.ILocalService;
import com.unla.TPObjetosII.services.ILoteService;

@RestController
@RequestMapping("/api/stock")
public class StockRestController {

	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	
	@PostMapping("/traerProductos")
	@ResponseBody
	public List<ProductoModel> traerProductos(@RequestBody LocalModel localModel) throws Exception{
		return loteService.CantidadProductoXlocal(localModel.getIdLocal());
	}
	
	@PostMapping("/traerProducto")
	@ResponseBody
	public ProductoModel traerProducto(@RequestBody ObjectNode o) {
		return loteService.ProductoXlocal(o.get("idProducto").asInt(), o.get("idLocal").asInt());
	}
	
	@PostMapping("/traerLocalesConStock")
	@ResponseBody
	public List<LocalModel> traerLocalesConStockDistanciaYCantidad(@RequestBody ObjectNode o) throws Exception{
		LocalModel local=localService.getById(o.get("idLocal").asInt());
		int idProducto=o.get("idProducto").asInt();
		return localService.traerLocalesConStockDistanciaYCantidad(idProducto, local);
	}

}
