package com.app.microservicio.acudiente.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.microservicio.acudiente.repository.AcudienteRepository;
import com.common.entidad.entity.Acudiente;
import com.common.microservicio.service.CommonServiceImpl;



@Service
public class AcudienteSerciceImpl extends CommonServiceImpl<Acudiente, AcudienteRepository> implements AcudienteService {


	@Override
	@Transactional(readOnly = true)
	public List<Acudiente> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Acudiente> findAll() {
		return repository.findAllByOrderByIdAsc();
	}
	
	
}
