package com.app.microservicio.acudiente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan ({"com.common.entidad.entity"})
public class MicroservicioAcudienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioAcudienteApplication.class, args);
	}

}
