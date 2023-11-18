package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.util.Objects;


public class Reto {
	private String nombre;
	private String fIni;
	private String fFin;
	private double dist;
	private double obj;// tiempo objetivo (50 km., 240 minutos)
	private String deporte;
	
	
	public Reto(String nombre, String fIni, String fFin, double dist, double obj, String deporte) {
		super();
		this.nombre = nombre;
		this.fIni = fIni;
		this.fFin = fFin;
		this.dist = dist;
		this.obj = obj;
		this.deporte = deporte;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getfIni() {
		return fIni;
	}


	public void setfIni(String fIni) {
		this.fIni = fIni;
	}


	public String getfFin() {
		return fFin;
	}


	public void setfFin(String fFin) {
		this.fFin = fFin;
	}


	public double getDist() {
		return dist;
	}


	public void setDist(double dist) {
		this.dist = dist;
	}


	public double getObj() {
		return obj;
	}


	public void setObj(double obj) {
		this.obj = obj;
	}


	public String getDeporte() {
		return deporte;
	}


	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}


	@Override
	public String toString() {
		return "Reto [nombre=" + nombre + ", fIni=" + fIni + ", fFin=" + fFin + ", dist=" + dist + ", obj=" + obj
				+ ", deporte=" + deporte + "]";
	}


	


	
	
	
	
}