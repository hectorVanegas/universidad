package com.app.microservicio.asignatura.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.microservicio.asignatura.repository.AsignaturaRepository;
import com.common.entidad.entity.Asignatura;
import com.common.microservicio.service.CommonServiceImpl;


@Service
public class AsignaturaServiceImpl extends CommonServiceImpl<Asignatura, AsignaturaRepository > implements AsignaturaService {

	@Override
	@Transactional(readOnly = true)
	public Iterable<Asignatura> findAll() {
		return repository.findAllByOrderByIdAsc();
	}

	

	

}
