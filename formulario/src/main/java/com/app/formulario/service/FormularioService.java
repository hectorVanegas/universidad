package com.app.formulario.service;

import java.util.Optional;

import com.app.formulario.entity.Formulario;

public interface FormularioService {
	
	public Iterable <Formulario> findAll();
	public Optional <Formulario> findById (Long id);
	public Formulario save (Formulario formulario);
	public void deleteById (Long id);
	
	

}
