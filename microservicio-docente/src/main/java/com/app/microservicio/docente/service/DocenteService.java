package com.app.microservicio.docente.service;


import java.util.List;

import com.common.entidad.entity.Docente;
import com.common.microservicio.service.CommonService;

public interface DocenteService extends CommonService <Docente>{
	
	
	public List <Docente> findByNombreOrApellido (String term);

}
