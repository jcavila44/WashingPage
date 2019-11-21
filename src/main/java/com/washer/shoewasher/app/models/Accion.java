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
@Table(name = "accion")
public class Accion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Accion;

	@Column(name = "descripcion")
	private String Descripcion;

	@Column(name = "ruta")
	private String Ruta;

	@Column(name = "id_estado")
	private long Id_Estado;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private Date Created_At;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date Updated_At;

	public Accion() {
		super();
	}

	public Accion(String descripcion, String ruta, long id_Estado) {
		super();
		Descripcion = descripcion;
		Ruta = ruta;
		Id_Estado = id_Estado;
	}

	public long getId_Accion() {
		return Id_Accion;
	}

	public void setId_Accion(long id_Accion) {
		Id_Accion = id_Accion;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getRuta() {
		return Ruta;
	}

	public void setRuta(String ruta) {
		Ruta = ruta;
	}

	public long getId_Estado() {
		return Id_Estado;
	}

	public void setId_Estado(long id_Estado) {
		Id_Estado = id_Estado;
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
