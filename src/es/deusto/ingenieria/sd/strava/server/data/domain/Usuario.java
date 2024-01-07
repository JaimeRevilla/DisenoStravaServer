package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import es.deusto.ingenieria.sd.strava.server.data.dto.TipoProveedor;

@Entity
public class Usuario {	
	private String nombre;
	private String contr;
	private String mail;
	private String fNac;
	private double peso;
	private int altura;
	private double fCardiacaMaxima;
	private double fCardiacaReposo;
	private String log;
	private TipoProveedor tipoProveedor;
	private List<Reto> retos = new ArrayList<>();
	private List<Reto> retosAct = new ArrayList<>();
	private List<Sesion> sesiones = new ArrayList<>();
	
	
	
	public Usuario(String nombre, String contr, String mail, String fNac, double peso, 
			int alt, double fCardMax, double fCardRep, String log, TipoProveedor tipoProveedor) {
		this.nombre = nombre;
		this.contr = contr;
		this.mail = mail;
		this.fNac = fNac;
		this.peso = peso;
		this.altura = alt;
		this.fCardiacaMaxima = fCardMax;
		this.fCardiacaReposo = fCardRep;
		this.log = log;
		this.tipoProveedor = tipoProveedor;
		this.retos = new ArrayList<>();
		this.sesiones = new ArrayList<>();
	}
		
	
	
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

	public List<Reto> getRetos() {
		return retos;
	}

	public void setRetos(List<Reto> retos) {
		this.retos = retos;
	}
	
	public List<Reto> getRetosAct() {
		return retosAct;
	}
	
	public void setRetosAct(List<Reto> retosAct) {
		this.retosAct = retosAct;
	}

	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
	public TipoProveedor getTipoProveedor() {
		return tipoProveedor;
	}



	public void setTipoProveedor(TipoProveedor tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
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
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.nombre);
		result.append(" - ");
		result.append(this.mail);
		result.append(" - (");
		result.append(this.retosAct.size());
		result.append(" retos) - (");
		result.append(this.sesiones.size());
		result.append(" sesiones)");
		
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.mail.equals(((Usuario)obj).mail);
		}
		
		return false;
	}
}