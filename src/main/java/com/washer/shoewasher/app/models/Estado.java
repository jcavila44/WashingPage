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
@Table(name="estado")
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id_Estado;
	
	@Column(name="nombre")
	private String Nombre;
	
	@Column(name="id_clase_estado")
	private long Id_Clase_Estado;
	
	@Column(name="created_at", updatable = false)
	@CreationTimestamp
    private Date Created_At;
	
	@Column(name="updated_at")
	@UpdateTimestamp
    private Date Updated_At;
	
	public Estado() {
		super();
	}
	
	public Estado(String nombre, long id_Clase_Estado) {
		super();
		Nombre = nombre;
		Id_Clase_Estado = id_Clase_Estado;
	}

	public Long getId_Estado() {
		return Id_Estado;
	}

	public void setId_Estado(Long id_Estado) {
		Id_Estado = id_Estado;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public long getId_Clase_Estado() {
		return Id_Clase_Estado;
	}

	public void setId_Clase_Estado(long id_Clase_Estado) {
		Id_Clase_Estado = id_Clase_Estado;
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
