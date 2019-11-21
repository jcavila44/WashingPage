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
@Table(name="tipo_usuario")
public class TipoUsuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id_Tipo_Usuario;
	
	@Column(name="nombre")
	private String Nombre;
	
	@Column(name="created_at", updatable = false)
	@CreationTimestamp
    private Date Created_At;
	
	@Column(name="updated_at")
	@UpdateTimestamp
    private Date Updated_At;

	public TipoUsuario() {
		super();
	}

	public TipoUsuario(String nombre) {
		super();
		Nombre = nombre;
	}

	public long getId_Tipo_Usuario() {
		return Id_Tipo_Usuario;
	}

	public void setId_Tipo_Usuario(long id_Tipo_Usuario) {
		Id_Tipo_Usuario = id_Tipo_Usuario;
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
