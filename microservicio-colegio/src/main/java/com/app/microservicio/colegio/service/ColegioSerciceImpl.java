package com.app.microservicio.colegio.service;

import org.springframework.stereotype.Service;

import com.app.microservicio.colegio.entity.Colegio;
import com.app.microservicio.colegio.repository.ColegioRepository;
import com.common.microservicio.service.CommonServiceImpl;



@Service
public class ColegioSerciceImpl extends CommonServiceImpl<Colegio, ColegioRepository> implements ColegioService {

	
}
