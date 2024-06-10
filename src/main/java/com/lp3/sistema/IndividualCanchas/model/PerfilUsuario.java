package com.lp3.sistema.IndividualCanchas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PerfilUsuario {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idperfil;
	 
	 @Column
	private Integer idusuario;
	private String nombre;
	private String fotoperfil;
	
	public Integer getIdperfil() {
		return idperfil;
	}
	public void setIdperfil(Integer idperfil) {
		this.idperfil = idperfil;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFotoperfil() {
		return fotoperfil;
	}
	public void setFotoperfil(String fotoperfil) {
		this.fotoperfil = fotoperfil;
	}
	@Override
	public String toString() {
		return "PerfilUsuario [idperfil=" + idperfil + ", idusuario=" + idusuario + ", nombre=" + nombre
				+ ", fotoperfil=" + fotoperfil + "]";
	}

}
