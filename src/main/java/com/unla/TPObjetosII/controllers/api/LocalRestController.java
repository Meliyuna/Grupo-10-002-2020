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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.models.SolicitudStockModel;
import com.unla.TPObjetosII.services.IEmpleadoService;
import com.unla.TPObjetosII.services.ILocalService;
import com.unla.TPObjetosII.services.IPedidoService;
import com.unla.TPObjetosII.services.ISolicitudStockService;

@RestController
@RequestMapping("/api/local")
public class LocalRestController {
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@Autowired
	@Qualifier("solicitudStockService")
	private ISolicitudStockService solicitudStockService;
	
	
	@PostMapping("/alta")
	@ResponseBody
	public LocalModel alta(@RequestBody LocalModel local) throws Exception{//@RequestBody setea auto los atributos a local
		System.out.println(localService.insertOrUpdate(local));
		return local;
		// queda ver como devolver un mensaje simple
	}
	
	@PostMapping("/traerLocales")
	@ResponseBody
	public List<Local> traerLocales() throws Exception{
		return localService.getAll();
	}
	
	@PostMapping("/baja")
	@ResponseBody
	public Boolean baja(@RequestBody ObjectNode o) throws Exception{
		if(localService.remove(o.get("idLocal").asInt())==false) throw new Exception("Error al eliminar local");
		return true;
	}
	
	@PostMapping("/traerLocal")
	@ResponseBody
	public LocalModel traerLocal(@RequestBody ObjectNode o) throws Exception{
		return localService.getById(o.get("idLocal").asInt());
	}
	
	@PostMapping("/traerLocalesPorDistancia")
	@ResponseBody
	public List<LocalModel> traerLocalesPorDistancia(LocalModel local) throws Exception{
		return localService.traerLocalesConDistancia(local);
	}
	
	@PostMapping("/aceptarSolicitudStock")
	@ResponseBody
	public SolicitudStockModel aceptarSolicutudStock(@RequestBody ObjectNode o) throws Exception{
		SolicitudStockModel solicitud = solicitudStockService.getById((o.get("idSolicitudStock").asInt()));
		EmpleadoModel vendedorAux=empleadoService.getEmpleado((o.get("idEmpleado").asInt()));
		return localService.aceptarSolicitudStock(solicitud,vendedorAux);
	}
	
	@PostMapping("/negarSolicitudStock")
	@ResponseBody
	public SolicitudStockModel negarSolicutudStock(@RequestBody ObjectNode o) throws Exception{
		SolicitudStockModel solicitud = solicitudStockService.getById((o.get("idSolicitudStock").asInt()));
		return localService.negarSolicitudStock(solicitud);
	}
	
	@PostMapping("/traerSolicitudesStock")
	@ResponseBody
	public ArrayNode traerSolicitudesStock(@RequestBody ObjectNode o){
		LocalModel local= localService.getById(o.get("idLocal").asInt());
		List<SolicitudStockModel> listaS = localService.traerSolicitudesStock(local);
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode listaNode = mapper.createArrayNode();
		ObjectNode solNode = null;
		for(SolicitudStockModel sol: listaS) {
			solNode = mapper.valueToTree(sol);
			solNode.set("pedido", ((ObjectNode)mapper.valueToTree(sol.getPedido()))
					.set("local", mapper.valueToTree(sol.getPedido().getCarrito().getLocal())));
			listaNode.add(solNode);
		}
		return listaNode;
	}
	
	
	
//	@PostMapping("/alta2")
//	public ResponseEntity<LocalModel> alta2(@RequestBody ObjectNode o) throws Exception{
//		Gson gson = new Gson();
//		String local = o.get("local").toString();
//		LocalModel lc = gson.fromJson(local, LocalModel.class);
//		System.out.println(lc);
//		return ResponseEntity.badRequest().build();
//	}
}