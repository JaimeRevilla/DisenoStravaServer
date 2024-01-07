package es.deusto.ingenieria.sd.strava.dao;

import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;


public interface IStravaDAO {

	public void storeUsuario(Usuario usuario);
	public Usuario getUsuario(String mail, String password);
	public Usuario getUsuario(String mail);
	public void updateUsuario(Usuario usuario);
	
	public List<Reto> getRetos(Usuario usuario);
	public List<Sesion> getSesiones(Usuario usuario);
	public List<Reto> getRetosActivos(Usuario usuario);

	public void deleteAllUsuarios();

}
