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
@Table(name="pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id_Pedido;
	
	@Column(name="coordenadas")
	private String Coordenadas;
	
	@Column(name="cantidad_calzado")
	private String Cantidad_Calzado;
	
	@Column(name="direccion_entrega")
	private String Direccion_Entrega;
	
	@Column(name="direccion_recepcion")
	private String Direccion_Recepcion;
	
	@Column(name="id_cliente")
	private long Id_Cliente;
	
	@Column(name="id_mensajero")
	private long Id_Mensajero;
	
	@Column(name="id_tipo_calzado")
	private long Id_Tipo_Calzado;
	
	@Column(name="id_color")
	private long Id_Color;
	
	@Column(name="id_talla")
	private long ID_Talla;
	
	@Column(name="id_material")
	private long Id_Material;
	
	@Column(name="id_tipo_lavado")
	private long Id_Tipo_Lavado;
	
	@Column(name="created_at", updatable = false)
	@CreationTimestamp
    private Date Created_At;
	
	@Column(name="updated_at")
	@UpdateTimestamp
    private Date Updated_At;

	public Pedido() {
		super();
	}

	public Pedido(String coordenadas, String cantidad_Calzado, String direccion_Entrega, String direccion_Recepcion,
			long id_Cliente, long id_Mensajero, long id_Tipo_Calzado, long id_Color, long iD_Talla, long id_Material,
			long id_Tipo_Lavado) {
		super();
		Coordenadas = coordenadas;
		Cantidad_Calzado = cantidad_Calzado;
		Direccion_Entrega = direccion_Entrega;
		Direccion_Recepcion = direccion_Recepcion;
		Id_Cliente = id_Cliente;
		Id_Mensajero = id_Mensajero;
		Id_Tipo_Calzado = id_Tipo_Calzado;
		Id_Color = id_Color;
		ID_Talla = iD_Talla;
		Id_Material = id_Material;
		Id_Tipo_Lavado = id_Tipo_Lavado;
	}

	public Long getId_Pedido() {
		return Id_Pedido;
	}

	public void setId_Pedido(Long id_Pedido) {
		Id_Pedido = id_Pedido;
	}

	public String getCoordenadas() {
		return Coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		Coordenadas = coordenadas;
	}

	public String getCantidad_Calzado() {
		return Cantidad_Calzado;
	}

	public void setCantidad_Calzado(String cantidad_Calzado) {
		Cantidad_Calzado = cantidad_Calzado;
	}

	public String getDireccion_Entrega() {
		return Direccion_Entrega;
	}

	public void setDireccion_Entrega(String direccion_Entrega) {
		Direccion_Entrega = direccion_Entrega;
	}

	public String getDireccion_Recepcion() {
		return Direccion_Recepcion;
	}

	public void setDireccion_Recepcion(String direccion_Recepcion) {
		Direccion_Recepcion = direccion_Recepcion;
	}

	public long getId_Cliente() {
		return Id_Cliente;
	}

	public void setId_Cliente(long id_Cliente) {
		Id_Cliente = id_Cliente;
	}

	public long getId_Mensajero() {
		return Id_Mensajero;
	}

	public void setId_Mensajero(long id_Mensajero) {
		Id_Mensajero = id_Mensajero;
	}

	public long getId_Tipo_Calzado() {
		return Id_Tipo_Calzado;
	}

	public void setId_Tipo_Calzado(long id_Tipo_Calzado) {
		Id_Tipo_Calzado = id_Tipo_Calzado;
	}

	public long getId_Color() {
		return Id_Color;
	}

	public void setId_Color(long id_Color) {
		Id_Color = id_Color;
	}

	public long getID_Talla() {
		return ID_Talla;
	}

	public void setID_Talla(long iD_Talla) {
		ID_Talla = iD_Talla;
	}

	public long getId_Material() {
		return Id_Material;
	}

	public void setId_Material(long id_Material) {
		Id_Material = id_Material;
	}

	public long getId_Tipo_Lavado() {
		return Id_Tipo_Lavado;
	}

	public void setId_Tipo_Lavado(long id_Tipo_Lavado) {
		Id_Tipo_Lavado = id_Tipo_Lavado;
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
