package com.app.microservicio.docente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan ({"com.common.entidad.entity"})
public class MicroservicioDocenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioDocenteApplication.class, args);
	}

}
