package es.deusto.ingenieria.sd.strava.server.service;

import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class SesionAppService {
	public static void makeSesion(Sesion sesion, Usuario usuario) {
		Usuario u = LoginAppService.getMapUsuario().get(usuario.getMail());
		u.getSesiones().add(sesion);
        LoginAppService.getMapUsuario().put(usuario.getMail(), u);
    }
}
