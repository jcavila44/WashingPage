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
@Table(name = "accion_tipo_usuario")
public class AccionTipoUsuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Accion_Tipo_Usuario;

	@Column(name = "id_accion")
	private long Id_Accion;

	@Column(name = "id_tipo_usuario")
	private long Id_Tipo_Usuario;

	@Column(name = "id_estado")
	private long Id_Estado;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private Date Created_At;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date Updated_At;

	public AccionTipoUsuario() {
		super();
	}

	public AccionTipoUsuario(long id_Accion, long id_Tipo_Usuario, long id_Estado) {
		super();
		Id_Accion = id_Accion;
		Id_Tipo_Usuario = id_Tipo_Usuario;
		Id_Estado = id_Estado;
	}

	public long getId_Accion_Tipo_Usuario() {
		return Id_Accion_Tipo_Usuario;
	}

	public void setId_Accion_Tipo_Usuario(long id_Accion_Tipo_Usuario) {
		Id_Accion_Tipo_Usuario = id_Accion_Tipo_Usuario;
	}

	public long getId_Accion() {
		return Id_Accion;
	}

	public void setId_Accion(long id_Accion) {
		Id_Accion = id_Accion;
	}

	public long getId_Tipo_Usuario() {
		return Id_Tipo_Usuario;
	}

	public void setId_Tipo_Usuario(long id_Tipo_Usuario) {
		Id_Tipo_Usuario = id_Tipo_Usuario;
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
