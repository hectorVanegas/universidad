package com.app.microservicio.colegio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan ({"com.common.entidad.entity",
	          "com.app.microservicio.colegio.entity"})
public class MicroservicioColegioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioColegioApplication.class, args);
	}

}
