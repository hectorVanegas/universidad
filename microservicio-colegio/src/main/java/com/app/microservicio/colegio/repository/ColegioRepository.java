package com.app.microservicio.colegio.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.microservicio.colegio.entity.Colegio;


public interface ColegioRepository extends CrudRepository <Colegio, Long>{

}
