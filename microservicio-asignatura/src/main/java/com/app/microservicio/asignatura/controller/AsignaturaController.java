package com.app.microservicio.asignatura.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.microservicio.asignatura.service.AsignaturaService;
import com.common.entidad.entity.Alumno;
import com.common.entidad.entity.Asignatura;
import com.common.entidad.entity.Curso;
import com.common.entidad.entity.Docente;
import com.common.microservicio.controller.CommonController;



@RestController
@RequestMapping("/api/asignatura")
public class AsignaturaController extends CommonController <Asignatura, AsignaturaService>{
	
	@PutMapping ("/editar/{id}")
	public ResponseEntity <?> editar (@PathVariable Long id, @RequestBody Asignatura asignatura){
		Optional <Asignatura> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();	
		}
		Asignatura asignaturaDb = o.get();
		asignaturaDb.setNombre(asignatura.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(asignaturaDb));
	}
	
	@PutMapping ("/asignar-docente/{id}")
	public ResponseEntity <?> asignarDocentes (@RequestBody List <Docente> docentes , @PathVariable Long id ){
		Optional <Asignatura> o = service.findById(id);
		if (!o.isPresent()) {
			ResponseEntity.notFound().build();	
		}
		Asignatura  asignaturaDb = o.get();
		docentes.forEach(d ->{
			System.out.println(d);
			asignaturaDb.addDocente(d);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(asignaturaDb));
	}
	
	@PutMapping ("/eliminar-docente/{id}")
	public ResponseEntity <?> eliminarDocente (@RequestBody Docente  docente , @PathVariable Long id ){
		Optional <Asignatura> o = service.findById(id);
		if (!o.isPresent()) {
			ResponseEntity.notFound().build();	
		}
		Asignatura asignaturaDb = o.get();
		asignaturaDb.removeDocente(docente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(asignaturaDb));
	}

}