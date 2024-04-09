package com.app.microservicio.curso.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.microservicio.curso.repository.CursoRepository;
import com.common.entidad.entity.Curso;
import com.common.microservicio.service.CommonServiceImpl;



@Service
public class CursoSerciceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAsignaturaNombre(String term) {
		return repository.findCursoByAsignaturaNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Curso> findAll() {
		return repository.findAllByOrderByIdAsc();
	}

	





	
	
}
