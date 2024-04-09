package com.app.alumno.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.alumno.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
