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
@Table(name="usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id_Usuario;
	
	@Column(name="nombres")
	private String Nombres;
	
	@Column(name="apellidos")
	private String Apellidos;
	
	@Column(name="email", unique = true, updatable = false)
	private String Email;
	
	@Column(name="direccion")
	private String Direccion;
	
	@Column(name="barrio")
	private String Barrio;
	
	@Column(name="contrasena")
	private String Contrasena;
	
	@Column(name="id_rol")
	private long Id_Rol;
	
	@Column(name="id_estado")
	private long Id_Estado;
	
	@Column(name="id_depto")
	private long Id_Depto;
	
	@Column(name="id_ciudad")
	private long Id_Ciudad;
	
	@Column(name="created_at", updatable = false)
	@CreationTimestamp
//	@Temporal(TemporalType.TIMESTAMP)
    private Date Created_At;
	
	@Column(name="updated_at")
	@UpdateTimestamp
//	@Temporal(TemporalType.TIMESTAMP)
    private Date Updated_At;
	

	public Usuario() {
		super();
	}
	
	public Long getId_Usuario() {
		return Id_Usuario;
	}

	public void setId_Usuario(Long id_Usuario) {
		Id_Usuario = id_Usuario;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getBarrio() {
		return Barrio;
	}

	public void setBarrio(String barrio) {
		Barrio = barrio;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public long getId_Rol() {
		return Id_Rol;
	}

	public void setId_Rol(long id_rol) {
		Id_Rol = id_rol;
	}

	public long getId_Estado() {
		return Id_Estado;
	}

	public void setId_Estado(long id_Estado) {
		Id_Estado = id_Estado;
	}

	public long getId_Depto() {
		return Id_Depto;
	}

	public void setId_Depto(long id_Depto) {
		Id_Depto = id_Depto;
	}

	public long getId_Ciudad() {
		return Id_Ciudad;
	}

	public void setId_Ciudad(long id_Ciudad) {
		Id_Ciudad = id_Ciudad;
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
