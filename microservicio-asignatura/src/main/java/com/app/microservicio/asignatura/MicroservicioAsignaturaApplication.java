package com.app.microservicio.asignatura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan ({"com.common.entidad.entity"})
public class MicroservicioAsignaturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioAsignaturaApplication.class, args);
	}

}
