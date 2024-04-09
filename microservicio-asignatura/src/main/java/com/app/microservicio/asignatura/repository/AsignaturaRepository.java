package com.app.microservicio.asignatura.repository;

import org.springframework.data.repository.CrudRepository;

import com.common.entidad.entity.Asignatura;



public interface AsignaturaRepository extends CrudRepository<Asignatura, Long> {
	
	public Iterable<Asignatura> findAllByOrderByIdAsc();

}
