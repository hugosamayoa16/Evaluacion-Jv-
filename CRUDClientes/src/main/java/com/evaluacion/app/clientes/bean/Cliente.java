package com.evaluacion.app.clientes.bean;

import java.beans.ConstructorProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cliente {
	@JsonProperty("clienteid")
	private int clienteid;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("edad")
	private int edad;
	@JsonProperty("sexo")
	private String sexo;
	@JsonProperty("correo")
	private String correo;
	
	
	@ConstructorProperties({ "clienteid",  "nombre",  "edad",  "sexo",  "correo"})
	public Cliente(int clienteid, String nombre, int edad, String sexo, String correo) {
	
		this.clienteid = clienteid;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.correo = correo;
	}

	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Cliente [clienteid=" + clienteid + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo
				+ ", correo=" + correo + "]";
	}

}
