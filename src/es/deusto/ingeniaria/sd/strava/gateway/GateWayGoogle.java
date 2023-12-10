package es.deusto.ingeniaria.sd.strava.gateway;

import org.springframework.web.client.RestTemplate;

public class GateWayGoogle {
	private static GateWayGoogle gateWay;
	private RestTemplate restTemplate = new RestTemplate();
	private String serverURL = "http://127.0.0.1";
	private int serverPort = 8002;
	
	private GateWayGoogle() {
		
	}
	
	public static GateWayGoogle getGateWay() {
		if(gateWay == null) {
			gateWay = new GateWayGoogle();
		}
		return gateWay;
	}
	
	public boolean login(String email, String contrasena) {				
		try {
			System.out.format("login(): %s:%d/strava/login ...", serverURL, serverPort);
			
			String message = email + "#" + contrasena;

			return restTemplate.postForObject(String.format("%s:%d/strava/login", serverURL, serverPort), message, Boolean.class);
			
		} catch (Exception ex) {
			System.out.println("   # Error en login(): " + ex.getMessage());
			return false;
		}
	}
	
	public boolean comprobarUsuario(String email) {		
		boolean result = false;
		
		try {
			result = restTemplate.postForObject(String.format("%s:%d/strava/comprobarUsuario", serverURL, serverPort), email, Boolean.class);
		} catch (Exception ex) {
			System.out.println("   # Error en comprobarUsuario(): " + ex.getMessage());
		}		
		return result;
	}
}
