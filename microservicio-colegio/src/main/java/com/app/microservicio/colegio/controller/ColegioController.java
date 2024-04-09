package com.app.microservicio.colegio.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservicio.colegio.entity.Colegio;
import com.app.microservicio.colegio.service.ColegioService;
import com.common.entidad.entity.Curso;
import com.common.microservicio.controller.CommonController;


@RestController
@RequestMapping("/api/colegio")
public class ColegioController extends CommonController <Colegio, ColegioService>{

	
	@PutMapping ("/editar/{id}")
	public ResponseEntity <?> editar (@PathVariable Long id, @RequestBody Colegio colegio){
		Optional <Colegio> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();	
		}
		Colegio colegioDb = o.get();
		colegioDb.setNombre(colegio.getNombre());
		colegioDb.setDireccion(colegio.getDireccion());
		colegioDb.setEmail(colegio.getEmail());
		colegioDb.setTelefono(colegio.getTelefono());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(colegioDb));
	}
	
	@PutMapping ("/asignar-curso/{id}")
	public ResponseEntity <?> asignarCursos (@RequestBody List <Curso> cursos , @PathVariable Long id ){
	Optional <Colegio> o = service.findById(id);
		if (!o.isPresent()) {
			ResponseEntity.notFound().build();	
		}
		Colegio colegioDb = o.get();
		cursos.forEach(c ->{
			System.out.println(c);
			colegioDb.addCurso(c);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(colegioDb));
	}
	
	@PutMapping ("/eliminar-curso/{id}")
	public ResponseEntity <?> eliminarCursos (@RequestBody Curso curso , @PathVariable Long id ){
		Optional <Colegio> o = service.findById(id);
		if (!o.isPresent()) {
			ResponseEntity.notFound().build();	
		}
		Colegio colegioDb = o.get();
		colegioDb.removeCurso(curso);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(colegioDb));
	}
	
	
		}
	
