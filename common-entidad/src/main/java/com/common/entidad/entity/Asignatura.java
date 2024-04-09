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
@Table (name = "asignaturas")
public class Asignatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nombre;

	@OneToMany(fetch = FetchType.LAZY)
	private List <Docente> docentes ;
	
	public Asignatura () {
		this.docentes = new ArrayList <>();
	}
	public Long getId() {
		return id;
	}
	public void setIdA(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Docente> getDocentes() {
		return docentes;
	}
	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}
	public void addDocente(Docente docente) {
		this.docentes.add(docente);
	}
	public void removeDocente(Docente docente) {
		this.docentes.remove(docente);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Asignatura )) {
			return false;	
		}
		Asignatura a = (Asignatura ) obj;
		return this.id != null && this.id.equals(a.getId());
	
	}
	
}

