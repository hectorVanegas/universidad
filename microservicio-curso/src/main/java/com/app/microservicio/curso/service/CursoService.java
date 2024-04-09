package com.app.microservicio.curso.service;


import com.common.entidad.entity.Curso;
import com.common.microservicio.service.CommonService;

public interface CursoService extends CommonService <Curso>{
	
	public Curso findCursoByAlumnoId(Long id);
	
	public Curso findCursoByAsignaturaNombre(String term);
}
