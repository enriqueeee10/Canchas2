package com.lp3.sistema.IndividualCanchas.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DetalleReserva {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddetalle;
	private Integer idreserva;
	private Integer idcanchafutbol;
	
	@Column
	private Date fechahora;
	
	public Integer getIddetalle() {
		return iddetalle;
	}
	public void setIddetalle(Integer iddetalle) {
		this.iddetalle = iddetalle;
	}
	public Integer getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(Integer idreserva) {
		this.idreserva = idreserva;
	}
	public Integer getIdcanchafutbol() {
		return idcanchafutbol;
	}
	public void setIdcanchafutbol(Integer idcanchafutbol) {
		this.idcanchafutbol = idcanchafutbol;
	}
	public Date getFechahora() {
		return fechahora;
	}
	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}
	@Override
	public String toString() {
		return "DetalleReserva [iddetalle=" + iddetalle + ", idreserva=" + idreserva + ", idcanchafutbol="
				+ idcanchafutbol + ", fechahora=" + fechahora + "]";
	}
	
}