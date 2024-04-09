package com.app.microservicio.alumno.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.microservicio.alumno.repository.AlumnoRepository;
import com.common.entidad.entity.Acudiente;
import com.common.entidad.entity.Alumno;
import com.common.microservicio.service.CommonServiceImpl;


@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository > implements AlumnoService {

	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findAlumnoByAcudienteNombre(String term) {
		return repository.findAlumnoByAcudienteNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAll() {
		return repository.findAllByOrderByIdAsc();
	}

	
	
}
