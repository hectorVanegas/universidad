package com.app.microservicio.docente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.common.entidad.entity.Docente;


public interface DocenteRepository extends CrudRepository<Docente, Long> {
	
	
	@Query ("select d from Docente d where d.nombre like %?1% or d.apellido like %?1% ")
	public List <Docente> findByNombreOrApellido (String term);
	
	public Iterable <Docente> findAllByOrderByIdAsc();
}


