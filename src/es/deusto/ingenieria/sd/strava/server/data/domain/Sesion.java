package es.deusto.ingenieria.sd.strava.server.data.domain;

public class Sesion {
	private String titulo;
	private String deporte;
	private double km;
	private String fInicio;
	private int tiempo;
	private double duracion;

	public Sesion(String titulo, String deporte, double km, String fInicio, int tiempo, double duracion) {
		super();
		this.titulo = titulo;
		this.deporte = deporte;
		this.km = km;
		this.fInicio = fInicio;
		this.tiempo = tiempo;
		this.duracion = duracion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
		

}