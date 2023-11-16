package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SesionDto implements Serializable{
	//This attribute is needed to implement the "Serializable" interface.
	private String titulo;
	private String deporte;
	private double km;
	private String fInicio;
	private int hora;
	private double duracion;
	private static final String[] TIPOS = {"Running", "Ciclismo"};
	
	public static List<String> getTipoDeporte() {
		List<String> tipoDeporte = new ArrayList<>();
		for(String s: TIPOS) {
			tipoDeporte.add(s);
		}
		return tipoDeporte;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDeporte() {
		return deporte;
	}
	
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public String getfInicio() {
		return fInicio;
	}

	public void setfInicio(String fInicio) {
		this.fInicio = fInicio;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.titulo);
		result.append(" - ");
		result.append(this.km);
		result.append("km - Session begin: ");
		result.append(this.fInicio);
		result.append(" - Start time: ");
		result.append(this.hora);
		result.append(" - Tot. Time: ");
		result.append(this.duracion);
		result.append(" minutes");
			
		return result.toString();
	}
}