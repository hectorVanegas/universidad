package com.app.microservicio.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan ({"com.common.entidad.entity"})
public class MicroservicioCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCursoApplication.class, args);
	}

}
