package com.app.microservicio.acudiente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.common.entidad.entity.Acudiente;


public interface AcudienteRepository extends CrudRepository<Acudiente, Long> {
	
	
	@Query ("select a from Acudiente a where a.nombre like %?1% or a.apellido like %?1% ")
	public List <Acudiente> findByNombreOrApellido (String term);
	
	public Iterable<Acudiente> findAllByOrderByIdAsc();
}

