package com.app.microservicio.usuario.service;

import org.springframework.stereotype.Service;

import com.app.microservicio.usuario.repository.UsuarioRepository;
import com.common.entidad.entity.Usuario;
import com.common.microservicio.service.CommonServiceImpl;




@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, UsuarioRepository > implements UsuarioService {

	
	

}
