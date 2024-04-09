package com.app.microservicio.usuario.repository;

import org.springframework.data.repository.CrudRepository;

import com.common.entidad.entity.Usuario;



public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
