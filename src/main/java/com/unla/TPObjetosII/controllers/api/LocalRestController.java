package com.unla.TPObjetosII.controllers.api;

import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.TPObjetosII.models.LocalModel;

@RestController
@RequestMapping("/api/local")
public class LocalRestController {
	
	@PostMapping("/alta")
	public ResponseEntity<LocalModel> alta(@RequestBody LocalModel local){//@RequestBody setea auto los atributos a local
		System.out.println(local);
		return ResponseEntity.ok(local);//ResponseEntity puede devolver models y los convierte en json
		// queda ver como devolver un mensaje simple
	}
}
