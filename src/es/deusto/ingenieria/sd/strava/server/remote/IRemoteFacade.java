package es.deusto.ingenieria.sd.strava.server.remote;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public void signup(String nombre, String contr, String mail, String fNac, 
            double peso, int altura, double fCardiacaMaxima, double fCardiacaReposo, String log) throws RemoteException;

	public List<String> getDeporte() throws RemoteException;

    public List<String> getDeporteRet() throws RemoteException;

    public List<String> getReto() throws RemoteException;
    
    public List<String> getSesion() throws RemoteException;

    public List<String> getRetoActivado() throws RemoteException;

    public void makeSesion(String titulo, String deporte, double km, String fInicio, 
            int hora, double duracion) throws RemoteException;

    public void makeReto(String nombre, String fInicio, String fFin, 
            double distancia, double objetivo, String deporte) throws RemoteException;

    public void activateReto(String nombre) throws RemoteException;
    
    

}
