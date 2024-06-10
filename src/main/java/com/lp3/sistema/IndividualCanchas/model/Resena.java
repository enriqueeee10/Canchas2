package com.lp3.sistema.IndividualCanchas.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Resena {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idresena;
	private Integer idusuario;
	private Integer idcanchafutbol;
	private Integer puntuacion;
	private String comentario;
	private Date fecharesena;
	
	public Integer getIdresena() {
		return idresena;
	}
	public void setIdresena(Integer idresena) {
		this.idresena = idresena;
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
	public Integer getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Date getFecharesena() {
		return fecharesena;
	}
	public void setFecharesena(Date fecharesena) {
		this.fecharesena = fecharesena;
	}
	@Override
	public String toString() {
		return "Resena [idresena=" + idresena + ", idusuario=" + idusuario + ", idcanchafutbol=" + idcanchafutbol
				+ ", puntuacion=" + puntuacion + ", comentario=" + comentario + ", fecharesena=" + fecharesena + "]";
	}
	
	
}