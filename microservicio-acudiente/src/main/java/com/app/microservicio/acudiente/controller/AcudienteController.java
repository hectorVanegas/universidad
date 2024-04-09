package com.app.microservicio.acudiente.controller;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservicio.acudiente.service.AcudienteService;
import com.common.entidad.entity.Acudiente;
import com.common.microservicio.controller.CommonController;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/acudiente")
public class AcudienteController extends CommonController <Acudiente, AcudienteService>{

	
	@PutMapping ("/editar/{id}")
	public ResponseEntity <?> editar (@PathVariable Long id, @RequestBody Acudiente acudiente){
		Optional <Acudiente> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();	
		}
		Acudiente acudienteDb = o.get();
		acudienteDb.setNombre(acudiente.getNombre());
		acudienteDb.setApellido(acudiente.getApellido());
		acudienteDb.setEmail(acudiente.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(acudienteDb));
	}
	
	@GetMapping ("/filtrar/{term}")
	public ResponseEntity<?> filtrar (@PathVariable String term){
	return ResponseEntity.ok(service.findByNombreOrApellido(term));
}
	
}
