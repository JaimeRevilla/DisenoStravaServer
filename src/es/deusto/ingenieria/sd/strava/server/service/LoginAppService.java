package es.deusto.ingenieria.sd.strava.server.service;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import es.deusto.ingeniaria.sd.strava.gateway.Factory;
import es.deusto.ingeniaria.sd.strava.gateway.GateWayFacebook;
import es.deusto.ingeniaria.sd.strava.gateway.GateWayGoogle;
import es.deusto.ingenieria.sd.strava.dao.StravaDAO;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.dto.TipoProveedor;

public class LoginAppService {
	//private static Map<String, Usuario> mapaUsuario= new HashMap<>() ;
	private static LoginAppService instance;
	
	public static LoginAppService getInstance() {
		if(instance == null) {
			instance = new LoginAppService();
		}
		return instance;
	}

	private LoginAppService() {
		
	}
	
	
	public boolean signup(Usuario usuario) {
//		if (mapaUsuario.containsKey(usuario.getMail())) {
//			return false;
//		}
//		mapaUsuario.put(usuario.getMail(), usuario);
//		return true;
		if(StravaDAO.getInstance().getUsuario(usuario.getMail()) == null) {
			StravaDAO.getInstance().storeUsuario(usuario);
			return true;
		}
		return false;
	}
	
	public Usuario login(String mail, String contr) {
		try {
			if(StravaDAO.getInstance().getUsuario(mail) != null) {
				Usuario usuario = StravaDAO.getInstance().getUsuario(mail);
				if(Factory.getInstance().createGateWay(usuario.getTipoProveedor()).login(mail, contr)){
					return usuario;
					
				}
			}
			
		} catch(Exception e) {
			System.out.println("# LogIn error: " + e);
			return null;
		}
		return null;
	}
	

//	
//	public static Map<String, Usuario> getMapUsuario(){
//		return mapaUsuario;
//	}
}
