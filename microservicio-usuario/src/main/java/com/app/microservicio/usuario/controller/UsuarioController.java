package com.app.microservicio.usuario.controller;

import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservicio.usuario.service.UsuarioService;
import com.common.entidad.entity.Usuario;
import com.common.microservicio.controller.CommonController;



@RestController
@RequestMapping("/api/usuario")

public class UsuarioController extends CommonController <Usuario, UsuarioService>{
	
	@PutMapping ("/editar/{id}")
	public ResponseEntity <?> editar (@PathVariable Long id, @RequestBody Usuario login){
		Optional <Usuario> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();	
		}
		Usuario loginDb = o.get();
		loginDb.setUsuario(login.getUsuario());
		loginDb.setContrasena(login.getContrasena());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(loginDb));
	}
	
	
}