package es.deusto.ingenieria.sd.strava.server.data.dto;

	import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

	public class RetoDTO implements Serializable {
		private static final long serialVersionUID = 1L;
		private String nombre;
		private String fInicio;
		private String fFin;
		private double distancia;
		private double objetivo;
		private String deporte;
		private TipoDeporte tipoDeporte;
		

		public static List<String> getTipoDeporte() {
			List<String> tDep = new ArrayList<>();
			for (TipoDeporte t : TipoDeporte.values()) {
				tDep.add(t.toString());
				
			}
			return tDep;
		}

		public String getDeporte() {
			return deporte;
		}

		public void setDeporte(String deporte) {
			this.deporte = deporte;
		}



		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getfInicio() {
			return fInicio;
		}

		public void setfInicio(String fInicio) {
			this.fInicio = fInicio;
		}

		public String getfFin() {
			return fFin;
		}

		public void setfFin(String fFin) {
			this.fFin = fFin;
		}

		public double getDistancia() {
			return distancia;
		}

		public void setDistancia(double distancia) {
			this.distancia = distancia;
		}

		public double getObjetivo() {
			return objetivo;
		}

		public void setObjetivo(double objetivo) {
			this.objetivo = objetivo;
		}

		@Override
		public String toString() {
			return "RetoDTO [nombre=" + nombre + ", fInicio=" + fInicio + ", fFin=" + fFin + ", distancia=" + distancia
					+ ", objetivo=" + objetivo + ", tipoDeporte=" + tipoDeporte + "]";
		}
		
		
		
		
		
		
}



