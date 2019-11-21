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
@Table(name = "historial")
public class Historial implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Depto;

	@Column(name = "id_pedido")
	private String Id_Pedido;

	@Column(name = "id_estado")
	private String Id_Estado;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private Date Created_At;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date Updated_At;

	public Historial() {
		super();
	}

	public Historial(String id_Pedido, String id_Estado) {
		super();
		Id_Pedido = id_Pedido;
		Id_Estado = id_Estado;
	}

	public Long getId_Depto() {
		return Id_Depto;
	}

	public void setId_Depto(Long id_Depto) {
		Id_Depto = id_Depto;
	}

	public String getId_Pedido() {
		return Id_Pedido;
	}

	public void setId_Pedido(String id_Pedido) {
		Id_Pedido = id_Pedido;
	}

	public String getId_Estado() {
		return Id_Estado;
	}

	public void setId_Estado(String id_Estado) {
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
