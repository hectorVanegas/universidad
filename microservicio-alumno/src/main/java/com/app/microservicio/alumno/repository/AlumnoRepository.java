package com.app.microservicio.alumno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.common.entidad.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
	
	@Query ("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1% ")
		public List <Alumno> findByNombreOrApellido (String term);
	
	@Query ("select a from Alumno a join fetch a.acudientes ac where ac.nombre=?1")
		public Alumno findAlumnoByAcudienteNombre(String term);

		public Iterable<Alumno> findAllByOrderByIdAsc();
}
