package com.app.formulario.controller;

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

import com.app.formulario.entity.Formulario;
import com.app.formulario.service.FormularioService;


@RestController
public class FormularioController {

	@Autowired
	private FormularioService service;
	
	@GetMapping("/todos")
	public ResponseEntity <?> listar(){
		return ResponseEntity.ok().body(service.findAll());	
	}
	@GetMapping ("/{id}")
	public ResponseEntity <?> ver (@PathVariable Long id){
		Optional <Formulario> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
}
	
	@PostMapping("/crear")
	public ResponseEntity <?> crear (@RequestBody Formulario formulario) {
		Formulario formularioDb = service.save(formulario);
		return ResponseEntity.status(HttpStatus.CREATED).body(formularioDb);
	}
	@PutMapping ("/actualizar/{id}")
	public ResponseEntity <?> editar (@PathVariable Long id, @RequestBody Formulario formulario){
		Optional <Formulario> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();	
		}
		Formulario formularioDb = o.get();
		formularioDb.setNombre(formulario.getNombre());
		formularioDb.setApellido(formulario.getApellido());
		formularioDb.setEmail(formulario.getEmail());
		formularioDb.setContrasena(formulario.getContrasena());	
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(formularioDb));
	}
	@DeleteMapping ("/{id}")
		public ResponseEntity <?> eliminar (@PathVariable Long id){
			service.deleteById(id);
			return ResponseEntity.noContent().build();
		}
}