package es.deusto.ingenieria.sd.strava.server.service;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class RetoAppService {
	public static void activateReto(Reto reto, Usuario usuario) {
		Usuario u = LoginAppService.getMapUsuario().get(usuario.getMail());
        u.getRetosAct().add(reto);
        LoginAppService.getMapUsuario().put(usuario.getMail(), u);
    }
	public static void makeReto(Reto reto, Usuario user) {
        Usuario u = LoginAppService.getMapUsuario().get(user.getMail());
        u.getRetos().add(reto);
        LoginAppService.getMapUsuario().put(user.getMail(), u);
    }
}
