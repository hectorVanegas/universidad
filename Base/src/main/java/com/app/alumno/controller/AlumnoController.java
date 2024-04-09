package com.app.alumno.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.alumno.entity.Alumno;
import com.app.alumno.service.AlumnoService;


@RestController
public class AlumnoController {

	@Autowired
	private AlumnoService service;
	
	@GetMapping("/darTodos")
	public ResponseEntity <?> listar(){
		return ResponseEntity.ok().body(service.findAll());	
	}
	@GetMapping ("/darPorId/{id}")
	public ResponseEntity <?> ver (@PathVariable Long id){
		Optional <Alumno> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
}
	
	@PostMapping("/crear")
	public ResponseEntity <?> crear (@RequestBody Alumno alumno) {
		Alumno alumnoDb = service.save(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
	}
	@PutMapping ("/actualizar/{id}")
	public ResponseEntity <?> editar (@PathVariable Long id, @RequestBody Alumno alumno){
		Optional <Alumno> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();	
		}
		Alumno alumnoDb = o.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		alumnoDb.setContrasena(alumno.getContrasena());	
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
	}
	@DeleteMapping ("/eliminar/{id}")
		public ResponseEntity <?> eliminar (@PathVariable Long id){
			service.deleteById(id);
			return ResponseEntity.noContent().build();
		}
}