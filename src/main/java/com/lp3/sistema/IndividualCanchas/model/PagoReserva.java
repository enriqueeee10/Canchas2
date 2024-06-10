package com.lp3.sistema.IndividualCanchas.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class PagoReserva {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpago;
	 
	@Column
	private Integer idreserva;
	private String metodopago;
	private Double montopago;
	private Date fechahorapago;
	
	public Integer getIdpago() {
		return idpago;
	}
	public void setIdpago(Integer idpago) {
		this.idpago = idpago;
	}
	public Integer getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(Integer idreserva) {
		this.idreserva = idreserva;
	}
	public String getMetodopago() {
		return metodopago;
	}
	public void setMetodopago(String metodopago) {
		this.metodopago = metodopago;
	}
	public Double getMontopago() {
		return montopago;
	}
	public void setMontopago(Double montopago) {
		this.montopago = montopago;
	}
	public Date getFechahorapago() {
		return fechahorapago;
	}
	public void setFechahorapago(Date fechahorapago) {
		this.fechahorapago = fechahorapago;
	}
	@Override
	public String toString() {
		return "PagoReserva [idpago=" + idpago + ", idreserva=" + idreserva + ", metodopago=" + metodopago
				+ ", montopago=" + montopago + ", fechahorapago=" + fechahorapago + "]";
	} 
	
    
}