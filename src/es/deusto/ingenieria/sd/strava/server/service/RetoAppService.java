package es.deusto.ingenieria.sd.strava.server.service;

import es.deusto.ingenieria.sd.strava.dao.StravaDAO;
import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class RetoAppService {
	
private static RetoAppService instance;
	
	public static RetoAppService getInstance() {
		if(instance == null) {
			instance = new RetoAppService();
		}
		return instance;
	}
	
	private RetoAppService() {
		
	}
	
	public static void activateReto(Reto reto, Usuario usuario) {
		Usuario u = StravaDAO.getInstance().getUsuario(usuario.getMail());
		u.getRetosAct().add(reto);
		StravaDAO.getInstance().updateUsuario(u);
    }
	public static void makeReto(Reto reto, Usuario usuario) {
		Usuario u = StravaDAO.getInstance().getUsuario(usuario.getMail());
		u.getRetosAct().add(reto);
		StravaDAO.getInstance().updateUsuario(u);
	}
    
}
