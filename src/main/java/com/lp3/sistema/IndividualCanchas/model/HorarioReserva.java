package com.lp3.sistema.IndividualCanchas.model;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HorarioReserva {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idhorario;
	 
	 @Column
	private Integer idcanchafutbol;
	 private Integer idreserva;
	private Time horarioinicio;
	private Time horariofinal;
	public Integer getIdhorario() {
		return idhorario;
	}
	public void setIdhorario(Integer idhorario) {
		this.idhorario = idhorario;
	}
	public Integer getIdcanchafutbol() {
		return idcanchafutbol;
	}
	public void setIdcanchafutbol(Integer idcanchafutbol) {
		this.idcanchafutbol = idcanchafutbol;
	}
	public Integer getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(Integer idreserva) {
		this.idreserva = idreserva;
	}
	public Time getHorarioinicio() {
		return horarioinicio;
	}
	public void setHorarioinicio(Time horarioinicio) {
		this.horarioinicio = horarioinicio;
	}
	public Time getHorariofinal() {
		return horariofinal;
	}
	public void setHorariofinal(Time horariofinal) {
		this.horariofinal = horariofinal;
	}
	@Override
	public String toString() {
		return "HorarioReserva [idhorario=" + idhorario + ", idcanchafutbol=" + idcanchafutbol + ", idreserva="
				+ idreserva + ", horarioinicio=" + horarioinicio + ", horariofinal=" + horariofinal + "]";
	}
	
	
}