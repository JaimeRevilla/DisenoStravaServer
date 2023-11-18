package es.deusto.ingenieria.sd.strava.server.service;

import java.util.HashMap;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class LoginAppService {
	private static Map<String, Usuario> mapaUsuario= new HashMap<>() ;
	
	public boolean signup(Usuario usuario) {
		if (mapaUsuario.containsKey(usuario.getMail())) {
			return false;
		}
		mapaUsuario.put(usuario.getMail(), usuario);
		return true;
	}
	
	public Usuario login(String mail, String contr) {
		if (mapaUsuario.containsKey(mail)) {
			return mapaUsuario.get(mail);
		}
		return null;
	}
	
	public static Map<String, Usuario> getMapUsuario(){
		return mapaUsuario;
	}
}
