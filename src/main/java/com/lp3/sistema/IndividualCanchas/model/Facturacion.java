package com.lp3.sistema.IndividualCanchas.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Facturacion {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idfacturacion;
	private Integer idusuario;
	private Integer idpago;
	
	@Column
	private Date fechafacturacion;
	private Double totalfacturado;
	
	public Integer getIdfacturacion() {
		return idfacturacion;
	}
	public void setIdfacturacion(Integer idfacturacion) {
		this.idfacturacion = idfacturacion;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public Integer getIdpago() {
		return idpago;
	}
	public void setIdpago(Integer idpago) {
		this.idpago = idpago;
	}
	public Date getFechafacturacion() {
		return fechafacturacion;
	}
	public void setFechafacturacion(Date fechafacturacion) {
		this.fechafacturacion = fechafacturacion;
	}
	public Double getTotalfacturado() {
		return totalfacturado;
	}
	public void setTotalfacturado(Double totalfacturado) {
		this.totalfacturado = totalfacturado;
	}
	@Override
	public String toString() {
		return "Facturacion [idfacturacion=" + idfacturacion + ", idusuario=" + idusuario + ", idpago=" + idpago
				+ ", fechafacturacion=" + fechafacturacion + ", totalfacturado=" + totalfacturado + "]";
	}
	

}
