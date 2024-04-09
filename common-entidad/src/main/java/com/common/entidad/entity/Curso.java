package com.common.entidad.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name ="cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List <Alumno> alumnos;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List <Asignatura> asignaturas;
	
	public Curso( ) {
		this.alumnos = new ArrayList <>();	
		this.asignaturas = new ArrayList <>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}
	public void removeAlumno(Alumno alumno) {
		this.alumnos.remove(alumno);
	}
	
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public void addAsignatura(Asignatura asignatura) {
		this.asignaturas.add(asignatura);
	}
	public void removeAsignatura(Asignatura asignatura) {
		this.asignaturas.remove(asignatura);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Curso )) {
			return false;	
		}
		Curso cr = (Curso ) obj;
		return this.id != null && this.id.equals(cr.getId());
	
	}
}

