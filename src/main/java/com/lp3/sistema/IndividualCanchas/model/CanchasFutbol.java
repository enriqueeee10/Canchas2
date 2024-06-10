package com.lp3.sistema.IndividualCanchas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CanchasFutbol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcanchafutbol;

	@Column
	private String codigo;
	private String nombre;
	private String direccion;
	private Integer precio;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getIdcanchafutbol() {
		return idcanchafutbol;
	}

	public void setIdcanchafutbol(Integer idcanchafutbol) {
		this.idcanchafutbol = idcanchafutbol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

}