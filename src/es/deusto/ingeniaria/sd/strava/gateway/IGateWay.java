package es.deusto.ingeniaria.sd.strava.gateway;

import java.rmi.RemoteException;

public interface IGateWay {
	public boolean login(String mail, String contr) throws RemoteException;
}
