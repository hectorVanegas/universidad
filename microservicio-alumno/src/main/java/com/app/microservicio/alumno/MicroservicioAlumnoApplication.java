package com.app.microservicio.alumno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan ({"com.common.entidad.entity"})
public class MicroservicioAlumnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioAlumnoApplication.class, args);
	}

}
