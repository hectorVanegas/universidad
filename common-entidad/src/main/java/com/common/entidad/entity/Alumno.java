package com.common.entidad.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name = "alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	@Email
	private String email;

	@OneToMany(fetch = FetchType.LAZY)
	private List <Acudiente> acudientes;
	
	
	public Alumno( ) {
		this.acudientes = new ArrayList <>();		
	}
	public String getNombre() {
		return nombre;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Acudiente> getAcudientes() {
		return acudientes;
	}

	public void setAcudientes(List<Acudiente> acudientes) {
		this.acudientes = acudientes;
	}
	public void addAcudiente(Acudiente acudiente) {
		this.acudientes.add(acudiente);
	}

	public void removeAcudiente(Acudiente acudiente) {
		this.acudientes.remove(acudiente);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Alumno )) {
			return false;	
		}
		Alumno a = (Alumno ) obj;
		return this.id != null && this.id.equals(a.getId());
	
	}
	
	
	

}
