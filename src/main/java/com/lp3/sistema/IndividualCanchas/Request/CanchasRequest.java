package com.lp3.sistema.IndividualCanchas.Request;

public class CanchasRequest {
	
	Integer idcanchafutbol;
	String codigo;
	String nombre;
	String direccion;
	Integer precio;
	
	public Integer getIdcanchafutbol() {
		return idcanchafutbol;
	}
	public void setIdcanchafutbol(Integer idcanchafutbol) {
		this.idcanchafutbol = idcanchafutbol;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
