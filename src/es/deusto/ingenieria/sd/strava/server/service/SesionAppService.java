package es.deusto.ingenieria.sd.strava.server.service;

import es.deusto.ingenieria.sd.strava.dao.StravaDAO;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class SesionAppService {
private static SesionAppService instance;
	
	public static SesionAppService getInstance() {
		if(instance == null) {
			instance = new SesionAppService();
		}
		return instance;
	}
	
	private SesionAppService() {
		
	}
	
	
	public void makeSesion(Sesion sesion, Usuario usuario) {
		Usuario u = StravaDAO.getInstance().getUsuario(usuario.getMail());
		u.getSesiones().add(sesion);
		StravaDAO.getInstance().updateUsuario(u);
	}

}