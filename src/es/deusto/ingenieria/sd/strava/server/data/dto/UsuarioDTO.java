package es.deusto.ingenieria.sd.strava.server.data.dto;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;

	//This class implements DTO pattern
public class UsuarioDTO implements Serializable {	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String contr;
	private String mail;
	private String fNac;
	private double peso;
	private int altura;
	private double fCardiacaMaxima;
	private double fCardiacaReposo;
	private int estadp;
	private List<Reto> retos = new ArrayList<>();
	private List<Sesion> sesiones = new ArrayList<>();
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContr() {
		return contr;
	}
	public void setContr(String contr) {
		this.contr = contr;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getfNac() {
		return fNac;
	}
	public void setfNac(String fNac) {
		this.fNac = fNac;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public double getfCardiacaMaxima() {
		return fCardiacaMaxima;
	}
	public void setfCardiacaMaxima(double fCardiacaMaxima) {
		this.fCardiacaMaxima = fCardiacaMaxima;
	}
	public double getfCardiacaReposo() {
		return fCardiacaReposo;
	}
	public void setfCardiacaReposo(double fCardiacaReposo) {
		this.fCardiacaReposo = fCardiacaReposo;
	}
	public int getEstadp() {
		return estadp;
	}
	public void setEstadp(int estadp) {
		this.estadp = estadp;
	}
	public List<Reto> getRetos() {
		return retos;
	}
	public void setRetos(List<Reto> retos) {
		this.retos = retos;
	}
	public List<Sesion> getSesiones() {
		return sesiones;
	}
	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
		
	public void addSesion(Sesion sesion) {
		if (sesion != null && !this.sesiones.contains(sesion)) {
			this.sesiones.add(sesion);
		}
	}
	
	public void addReto(Reto reto) {
		if (reto != null && !this.retos.contains(reto)) {
			this.retos.add(reto);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.mail.equals(((UsuarioDTO)obj).mail);
		}
		
		return false;
	}
	
}