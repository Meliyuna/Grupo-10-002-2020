package com.unla.TPObjetosII.controllers.api;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unla.TPObjetosII.converters.EmpleadoConverter;
import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.services.IEmpleadoService;
import com.unla.TPObjetosII.services.IPedidoService;




@Controller
@RequestMapping("/api/empleado")
public class EmpleadoRestController {
	
	@Autowired	
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	@Autowired	
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	
	@PostMapping("/alta")
	@ResponseBody
	public EmpleadoModel alta(@RequestBody ObjectNode empleadoNode) throws Exception{  //RequestBody setea todos los atributos a empleado
		ObjectMapper mapper = new ObjectMapper(); //un objeto que me ayuda a mapear o crear el json
		EmpleadoModel e= mapper.treeToValue(empleadoNode, EmpleadoModel.class);	//convierte el object node a empleadoModel
		e.setLocal(mapper.treeToValue(empleadoNode.get("local"),LocalModel.class));
		long dni=e.getDni();
		if(empleadoService.getEmpleado(dni)!=null)throw new Exception("Ya existe empleado con ese dni");
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
		ObjectMapper mapper = new ObjectMapper(); //un objeto que me ayuda a mapear o crear el json
		EmpleadoModel e= mapper.treeToValue(empleadoNode, EmpleadoModel.class);	//convierte el object node a empleadoModel
		e.setLocal(mapper.treeToValue(empleadoNode.get("local"), LocalModel.class));
		long dni=e.getDni();
		if(empleadoService.getEmpleado(dni)!=null)if(empleadoService.getEmpleado(dni).getIdPersona()!=e.getIdPersona()) throw new Exception("Ya existe empleado con ese dni");
			
		System.out.println(empleadoService.insertOrUpdate(e));
		return e;
	
	}
	
	
	@PostMapping("/traerEmpleado")
	@ResponseBody
	public ObjectNode traerEmpleado(@RequestBody ObjectNode o) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		EmpleadoModel e=empleadoService.getEmpleado(o.get("idEmpleado").asInt());
		ObjectNode empleadoNode=mapper.convertValue(e, ObjectNode.class);// empleado que tiene todos menos el local
		ObjectNode localNode = null;
		System.out.println(e);
		if (e.getLocal()!=null)localNode=mapper.convertValue(e.getLocal(), ObjectNode.class);
		empleadoNode.set("local",localNode);
		//EmpleadoModel e= mapper.treeToValue(empleadoNode, EmpleadoModel.class);	
		return empleadoNode;
	}
	
	@PostMapping("/baja")
	@ResponseBody
	public Boolean baja(@RequestBody ObjectNode o) throws Exception{
		if(empleadoService.remove(o.get("idEmpleado").asInt())==false) throw new Exception("Error al eliminar empleado");
		return true;
	}
	
	@PostMapping("/mostrarSueldos") //Calcula el sueldo del empleado usando una base de 30k
	@ResponseBody
	public List<EmpleadoModel> mostrarSueldos () throws Exception {
		EmpleadoConverter empleadoConverter = new EmpleadoConverter();
		List <EmpleadoModel> emp = new ArrayList<EmpleadoModel>();
		List <Empleado> e = empleadoService.getAll();
		List <Pedido> p = pedidoService.getAll();
		float comision = 0;
		for (Empleado aux : e) {
			EmpleadoModel em = new EmpleadoModel(aux.getIdPersona(), aux.getApellido(), aux.getNombre(), aux.getFechaNacimiento(), aux.getDni(), aux.getFranjaHoraria(), aux.isTipoEmpleado());
			for (Pedido ped :p) {
				if (ped.getVendedorOriginal().getIdPersona()==aux.getIdPersona())
					if (ped.getVendedorAuxiliar()==null)
						comision+=ped.getSubtotal()*0.05;		
					else comision+=ped.getSubtotal()*0.03;
				if (ped.getVendedorAuxiliar()!=null && ped.getVendedorAuxiliar().getIdPersona()==aux.getIdPersona())
					comision+=ped.getSubtotal()*0.02;					
			}
			em.setSueldo(30000+comision);
			emp.add(em);
		}
		return emp;
	}
}



