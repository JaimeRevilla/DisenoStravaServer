package services;

//import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
//import es.deusto.ingenieria.sd.auctions.server.data.domain.User;

public class RetoAppService {

	public void makeReto(Reto reto, User user) {
		User u = LoginAppService.getUserMap().get(user.getEmail());
		u.getRetos().add(reto);
		LoginAppService.getUserMap().put(user.getEmail(), u);
	}
	
	public void activateReto(Reto reto, User user) {
		User u = LoginAppService.getUserMap().get(user.getEmail());
		u.getRetosAct().add(reto);
		LoginAppService.getUserMap().put(user.getEmail(), u);
	}
}