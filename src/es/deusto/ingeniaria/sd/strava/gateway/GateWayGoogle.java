package es.deusto.ingeniaria.sd.strava.gateway;

import java.rmi.Naming;
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.strava.remote.IGoogleServer;

public class GateWayGoogle implements IGateWay{
	private static GateWayGoogle gateWay;
	
	private IGoogleServer googleServer;
	
	
	private GateWayGoogle() {
		try {
			String url = "//127.0.0.1:1099/GoogleServer";//CUIDADO!!
			this.googleServer = (IGoogleServer) Naming.lookup(url); 
		} catch (Exception e) {
			System.err.println("Error : " + e);
		}
	}

	public static GateWayGoogle getGateWay() {
		if(gateWay == null) {
			gateWay = new GateWayGoogle();
		}
		return gateWay;
	}
	
	@Override
	public boolean login(String mail, String contr) throws RemoteException {
		System.out.println("   - LogIn from Google Servers");

		try {
			return this.googleServer.login(mail, contr);
		} catch(Exception e) {
			System.out.println(" $ Error LogIn with Google: " + e);
			return false;
		}
	}
}
