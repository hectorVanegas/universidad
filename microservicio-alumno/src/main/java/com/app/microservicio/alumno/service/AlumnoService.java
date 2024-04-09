package com.app.microservicio.alumno.service;

import java.util.List;

import com.common.entidad.entity.Alumno;
import com.common.microservicio.service.CommonService;


public interface AlumnoService extends CommonService<Alumno>{
		
	public List <Alumno> findByNombreOrApellido (String term);
	
	public Alumno findAlumnoByAcudienteNombre(String term);
}
