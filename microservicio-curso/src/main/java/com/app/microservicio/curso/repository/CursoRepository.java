package com.app.microservicio.curso.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.common.entidad.entity.Curso;

public interface CursoRepository extends CrudRepository <Curso, Long>{

@Query("select c from Curso c join fetch c.alumnos a where a.id=?1")
public Curso findCursoByAlumnoId(Long id);

@Query("select c from Curso c join fetch c.asignaturas a where a.nombre=?1")
public Curso findCursoByAsignaturaNombre(String term);


public Iterable<Curso> findAllByOrderByIdAsc();
}


