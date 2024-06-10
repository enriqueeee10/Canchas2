package com.lp3.sistema.IndividualCanchas.model;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idreserva;
	private Integer idusuario;
	private Integer idcanchafutbol;

	@Column
	private Date fechareserva;
	private Time horainicio;
	private Time horafinal;
	private Integer pago;
	private Integer totaldepositado;
	private String observaciones;
	
	public Integer getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(Integer idreserva) {
		this.idreserva = idreserva;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public Integer getIdcanchafutbol() {
		return idcanchafutbol;
	}
	public void setIdcanchafutbol(Integer idcanchafutbol) {
		this.idcanchafutbol = idcanchafutbol;
	}
	public Date getFechareserva() {
		return fechareserva;
	}
	public void setFechareserva(Date fechareserva) {
		this.fechareserva = fechareserva;
	}
	public Time getHorainicio() {
		return horainicio;
	}
	public void setHorainicio(Time horainicio) {
		this.horainicio = horainicio;
	}
	public Time getHorafinal() {
		return horafinal;
	}
	public void setHorafinal(Time horafinal) {
		this.horafinal = horafinal;
	}
	public Integer getPago() {
		return pago;
	}
	public void setPago(Integer pago) {
		this.pago = pago;
	}
	public Integer getTotaldepositado() {
		return totaldepositado;
	}
	public void setTotaldepositado(Integer totaldepositado) {
		this.totaldepositado = totaldepositado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	@Override
	public String toString() {
		return "Reserva [idreserva=" + idreserva + ", idusuario=" + idusuario + ", idcanchafutbol=" + idcanchafutbol
				+ ", fechareserva=" + fechareserva + ", horainicio=" + horainicio + ", horafinal=" + horafinal
				+ ", pago=" + pago + ", totaldepositado=" + totaldepositado + ", observaciones=" + observaciones + "]";
	}
	
	

}
