package com.unla.TPObjetosII.controllers.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.services.IEmpleadoService;




@Controller
@RequestMapping("/api/empleado")
public class EmpleadoRestController {
	
	@Autowired	
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	
	@PostMapping("/alta")
	@ResponseBody
	public EmpleadoModel alta(@RequestBody ObjectNode empleadoNode) throws Exception{  //RequestBody setea todos los atributos a empleado
		ObjectMapper mapper = new ObjectMapper().disable(MapperFeature.USE_ANNOTATIONS); //un objeto que me ayuda a mapear o crear el json
		// el disable esta para ignorar la etiqueta de JsonIgnore en LocalModel y que quede mapeado los 2
		EmpleadoModel e= mapper.treeToValue(empleadoNode, EmpleadoModel.class);	//convierte el object node a empleadoModel
		long dni=e.getDni();
		if(empleadoService.getEmpleado(dni)!=null)throw new Exception(",Ya existe empleado con ese dni");
		System.out.println(empleadoService.insertOrUpdate(e));
		return e;
	
	}
	
	
	@PostMapping("/traerEmpleados")
	@ResponseBody
	public List<Empleado> traerEmpleados() throws Exception{
		return empleadoService.getAll();
	}
	
	
	
	//hace lo mismo que alta pero para que quede mas claro en html se agrega modificar
	@PostMapping("/modificar")
	@ResponseBody
	public EmpleadoModel modificar(@RequestBody ObjectNode empleadoNode) throws Exception{  //RequestBody setea todos los atributos a empleado
		ObjectMapper mapper = new ObjectMapper().disable(MapperFeature.USE_ANNOTATIONS); //un objeto que me ayuda a mapear o crear el json
		// el disable esta para ignorar la etiqueta de JsonIgnore en LocalModel y que quede mapeado los 2
		EmpleadoModel e= mapper.treeToValue(empleadoNode, EmpleadoModel.class);	//convierte el object node a empleadoModel
		System.out.println(e);
		System.out.println(empleadoService.insertOrUpdate(e));
		return e;
	
	}
	
	
	@PostMapping("/traerEmpleado")
	@ResponseBody
	public EmpleadoModel traerEmpleado(@RequestBody ObjectNode o) throws Exception{
		return empleadoService.getEmpleado(o.get("idEmpleado").asInt());
	}
	
	@PostMapping("/baja")
	@ResponseBody
	public Boolean baja(@RequestBody ObjectNode o) throws Exception{
		if(empleadoService.remove(o.get("idEmpleado").asInt())==false) throw new Exception("Error al eliminar empleado");
		return true;
	}
	
	
}



