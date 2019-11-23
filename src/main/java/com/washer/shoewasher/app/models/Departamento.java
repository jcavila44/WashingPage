package com.washer.shoewasher.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="departamento")
public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id_Depto;
	
	@Column(name="nombre")
	private String Nombre;
	
	@Column(name="created_at", updatable = false)
	@CreationTimestamp
    private Date Created_At;
	
	@Column(name="updated_at")
	@UpdateTimestamp
    private Date Updated_At;

	public Departamento() {
		super();
	}

	public Departamento(String nombre) {
		super();
		Nombre = nombre;
	}

	public Long getId_Depto() {
		return Id_Depto;
	}

	public void setId_Depto(Long id_Depto) {
		Id_Depto = id_Depto;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Date getCreated_At() {
		return Created_At;
	}

	public void setCreated_At(Date created_At) {
		Created_At = created_At;
	}

	public Date getUpdated_At() {
		return Updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		Updated_At = updated_At;
	}
}
