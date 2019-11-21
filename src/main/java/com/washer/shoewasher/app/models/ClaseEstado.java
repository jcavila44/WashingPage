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
@Table(name = "clase_estado")
public class ClaseEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_ClaseEstado;

	@Column(name = "nombre")
	private String Nombre;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private Date Created_At;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date Updated_At;

	public ClaseEstado() {
		super();
	}

	public ClaseEstado(String nombre) {
		super();
		Nombre = nombre;
	}

	public Long getId_ClaseEstado() {
		return Id_ClaseEstado;
	}

	public void setId_ClaseEstado(Long id_ClaseEstado) {
		Id_ClaseEstado = id_ClaseEstado;
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
