package com.app.microservicio.acudiente.service;



import java.util.List;

import com.common.entidad.entity.Acudiente;
import com.common.microservicio.service.CommonService;

public interface AcudienteService extends CommonService <Acudiente>{

	
	public List <Acudiente> findByNombreOrApellido (String term);

	
}
