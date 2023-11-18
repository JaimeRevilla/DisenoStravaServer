package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.SesionAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.SesionDTO;
import es.deusto.ingenieria.sd.strava.server.service.LoginAppService;
import es.deusto.ingenieria.sd.strava.server.service.RetoAppService;
import es.deusto.ingenieria.sd.strava.server.service.SesionAppService;




public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private RetoAppService retoService = new RetoAppService();
	private SesionAppService sesionService = new SesionAppService();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public synchronized long login(String email, String contrasenia) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + contrasenia);
				
		//Perform login() using LoginAppService
		Usuario usuario = loginService.login(email, contrasenia);
			
		//If login() success user is stored in the Server State
		if (usuario != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(usuario)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, usuario);		
				return(token);
			} else {
				throw new RemoteException("Usuario ya esta logeado!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	@Override
	public synchronized void signup(String nombre, String contr, String mail, String fNac, 
            double peso, int altura, double fCardiacaMaxima, double fCardiacaReposo, String log) throws RemoteException{
		System.out.println(" * RemoteFacade signup(): " + nombre + " / " + contr);
		
		Usuario usuario = new Usuario(nombre, contr, mail, fNac, peso, altura, fCardiacaMaxima, fCardiacaReposo, log);
		
		
		if (!loginService.signup(usuario)) {
			throw new RemoteException("El usuario ya esta registrado! Registrate con otro usuario");
		}
	}
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);			
		if (this.serverState.containsKey(token)) {
			this.serverState.remove(token);
		} else {
			throw new RemoteException("El usuario no esta logeado!");
		}
	}
	
	@Override
    public List<String> getDeporte() throws RemoteException {
        return SesionDTO.getTipoDeporte();
    }

    @Override
    public List<String> getDeporteRet() throws RemoteException {
        return RetoDTO.getTipoDeporte();
    }

    @Override
    public List<String> getSesion() throws RemoteException {
        List<String> sesiones = new ArrayList<>();
        for(Sesion s: LoginAppService.getMapUsuario().get(serverState.get(serverState.keySet().toArray()[0]).getMail()).getSesiones()) {
            sesiones.add(SesionAssembler.sesionToDTO(s).toString());
        }
        return sesiones;
    }
    
    @Override
    public List<String> getReto() throws RemoteException {
        List<String> retos = new ArrayList<>();
        for(Reto r: LoginAppService.getMapUsuario().get(serverState.get(serverState.keySet().toArray()[0]).getMail()).getRetos()) {
            retos.add(RetoAssembler.retoToDTO(r).toString());
        }
        return retos;
    }

    @Override
    public List<String> getRetoActivado() throws RemoteException {
        List<String> retos = new ArrayList<>();
        for(Reto r: LoginAppService.getMapUsuario().get(serverState.get(serverState.keySet().toArray()[0]).getMail()).getRetosAct()) {
            retos.add(RetoAssembler.retoToDTO(r).toString());
        }
        return retos;
    }

    @Override
    public void activateReto(String nombre) throws RemoteException {
        System.out.println(" * Activating Reto: " + nombre);
        Usuario usuario = serverState.get(serverState.keySet().toArray()[0]);
        Reto reto = null;
        for(Reto r: LoginAppService.getMapUsuario().get(serverState.get(serverState.keySet().toArray()[0]).getMail()).getRetos()) {
            if(r.toString().equals(nombre)) {
                reto = r;
            }
        }
        if(reto != null) {
            RetoAppService.activateReto(reto, usuario);
        }
    }
    @Override
    public void makeSesion(String titulo, String deporte, double km, String fInicio, int hora, double duracion)
            throws RemoteException {
        System.out.println(" * Making Sesion: " + titulo + " " + deporte);
        Sesion sesion = new Sesion(titulo, deporte, km, fInicio, hora, duracion);
        Usuario usuario = serverState.get(serverState.keySet().toArray()[0]);
        SesionAppService.makeSesion(sesion, usuario);
    }

    @Override
    public void makeReto(String nombre, String fInicio, String fFin, double distancia, double objetivo,
            String deporte) throws RemoteException {
        System.out.println(" * Making Reto: " + nombre + " " + deporte);
        Reto reto = new Reto(nombre, fInicio, fFin, distancia, objetivo, deporte);
        Usuario usuario = serverState.get(serverState.keySet().toArray()[0]);
        RetoAppService.makeReto(reto, usuario);
    }
    
	
	
	
	
	
	
	
	
	
	
	
	
	

}