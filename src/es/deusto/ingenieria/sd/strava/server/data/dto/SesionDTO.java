package es.deusto.ingenieria.sd.strava.server.data.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SesionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String deporte;
	private double km;
	private String fInicio;
	private int tiempo;
	private double duracion;
	private TipoDeporte tipoDeporte;
	
	
	public static List<String> getTipoDeporte() {
		List<String> tDep = new ArrayList<>();
		for (TipoDeporte t : TipoDeporte.values()) {
			tDep.add(t.toString());
			
		}
		return tDep;
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

	

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
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
		result.append(this.tiempo);
		result.append(" - Tot. Time: ");
		result.append(this.duracion);
		result.append(" minutes");
			
		return result.toString();
	}
}



