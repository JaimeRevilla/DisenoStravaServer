package services;

//import es.deusto.ingenieria.sd.auctions.server.data.domain.Sesion;
//import es.deusto.ingenieria.sd.auctions.server.data.domain.User;

public class SesionAppService {
	
	public void makeSesion(Sesion sesion, User user) {
		User u = LoginAppService.getUserMap().get(user.getEmail());
		u.getSesiones().add(sesion);
		LoginAppService.getUserMap().put(user.getEmail(), u);
	}

}