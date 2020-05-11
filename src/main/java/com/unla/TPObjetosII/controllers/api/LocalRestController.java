package com.unla.TPObjetosII.controllers.api;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.services.ILocalService;

@RestController
@RequestMapping("/api/local")
public class LocalRestController {
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	@PostMapping("/alta")
	@ResponseBody
	public LocalModel alta(@RequestBody LocalModel local) throws Exception{//@RequestBody setea auto los atributos a local
		System.out.println(localService.insertOrUpdate(local));
		return local;
		// queda ver como devolver un mensaje simple
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