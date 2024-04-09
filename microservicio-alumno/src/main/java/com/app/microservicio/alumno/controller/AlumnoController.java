package com.app.microservicio.alumno.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.microservicio.alumno.service.AlumnoService;
import com.common.entidad.entity.Acudiente;
import com.common.entidad.entity.Alumno;
import com.common.microservicio.controller.CommonController;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController extends CommonController <Alumno, AlumnoService>{
	
	@PutMapping ("/editar/{id}")
	public ResponseEntity <?> editar (@PathVariable Long id, @RequestBody Alumno alumno){
		Optional <Alumno> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();	
		}
		Alumno alumnoDb = o.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());	
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
	}
	@GetMapping ("/filtrar/{term}")
		public ResponseEntity<?> filtrar (@PathVariable String term){
		return ResponseEntity.ok(service.findByNombreOrApellido(term));
	}
	
	
	@PutMapping ("/asignar-acudiente/{id}")
	public ResponseEntity <?> asignarAcudiente (@RequestBody List <Acudiente> acudientes , @PathVariable Long id ){
		Optional <Alumno> o = service.findById(id);
		if (!o.isPresent()) {
			ResponseEntity.notFound().build();	
		}
		Alumno alumnoDb = o.get();
		acudientes.forEach(a ->{
			System.out.println(a);
			alumnoDb.addAcudiente(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
	}
	
	@PutMapping ("eliminar-acudiente/{id}")
	public ResponseEntity <?> eliminarAcudiente
	(@RequestBody Acudiente acudiente , @PathVariable Long id ){
		Optional <Alumno> o = service.findById(id);
		if (!o.isPresent()) {
			ResponseEntity.notFound().build();	
		}
		Alumno alumnoDb = o.get();
		alumnoDb.removeAcudiente(acudiente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
	}
	
	@GetMapping("/acudiente/{term}")
	public ResponseEntity<?> buscarPorAcudienteNombre (@PathVariable String term){
	Alumno alumno = service.findAlumnoByAcudienteNombre(term);
		return ResponseEntity.ok(alumno);
}
}