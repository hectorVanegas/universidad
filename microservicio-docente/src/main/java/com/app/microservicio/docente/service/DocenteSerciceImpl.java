package com.app.microservicio.docente.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.microservicio.docente.repository.DocenteRepository;
import com.common.entidad.entity.Docente;
import com.common.microservicio.service.CommonServiceImpl;



@Service
public class DocenteSerciceImpl extends CommonServiceImpl<Docente, DocenteRepository> implements DocenteService {
	

	@Override
	@Transactional(readOnly = true)
	public List<Docente> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Docente> findAll() {
		return repository.findAllByOrderByIdAsc();
	}
	
	
	
}
