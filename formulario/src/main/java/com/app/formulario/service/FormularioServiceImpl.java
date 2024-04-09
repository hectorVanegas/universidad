package com.app.formulario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.formulario.entity.Formulario;
import com.app.formulario.repository.FormularioRepository;

@Service
public class FormularioServiceImpl implements FormularioService {

@Autowired
private FormularioRepository repository;

	
	
	@Override
	@Transactional (readOnly = true)
	public Iterable<Formulario> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Formulario> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Formulario save(Formulario formulario) {
		return repository.save(formulario);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
