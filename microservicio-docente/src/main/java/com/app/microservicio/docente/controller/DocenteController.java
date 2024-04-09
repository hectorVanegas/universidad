package com.app.microservicio.docente.controller;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservicio.docente.service.DocenteService;
import com.common.entidad.entity.Docente;
import com.common.microservicio.controller.CommonController;


@RestController
@RequestMapping("/api/docente")
public class DocenteController extends CommonController <Docente, DocenteService>{

	
	@PutMapping ("/editar/{id}")
	public ResponseEntity <?> editar (@PathVariable Long id, @RequestBody Docente docente){
		Optional <Docente> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();	
		}
		Docente docenteDb = o.get();
		docenteDb.setNombre(docente.getNombre());
		docenteDb.setApellido(docente.getApellido());
		docenteDb.setEmail(docente.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(docenteDb));
	}
	
	@GetMapping ("/filtrar/{term}")
	public ResponseEntity<?> filtrar (@PathVariable String term){
	return ResponseEntity.ok(service.findByNombreOrApellido(term));
}
	
}
