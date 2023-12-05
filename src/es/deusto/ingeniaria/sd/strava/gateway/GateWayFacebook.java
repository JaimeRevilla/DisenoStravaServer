package es.deusto.ingeniaria.sd.strava.gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;

public class GateWayFacebook implements IGateWay{
	private static GateWayFacebook gateWay;
	private String[] args;
	
	private GateWayFacebook() {
		args = new String[3];
		args[0] = "127.0.0.1";
		args[1] = "8001";
		args[2] = "Este es el socket Facebook!";
	}
	
	public void socket() {
		
		if (args.length < 3) {
			System.err.println(" # Usage: TCPSocketClient [SERVER IP] [PORT] [MESSAGE]");
			System.exit(1);
		}
		
		//args[0] = Server IP
		String serverIP = args[0];
		//args[1] = Server socket port
		int serverPort = Integer.parseInt(args[1]);
		//argrs[2] = Message
		String message = args[2];

		/**
		 * NOTE: try-with resources Statement - https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		 * Try statement that declares one or more resources. A resource is an object that must be closed after the program is 
		 * finished with it. The try-with-resources statement ensures that each resource is closed at the end of the statement.
		 * Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, 
		 * can be used as a resource.
		 */

		//Declaration of the socket to send/receive information to/from the server (an IP and a Port are needed)
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
			 //Streams to send and receive information are created from the Socket
		     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
			 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			
			//Send request (a Srting) to the server
			out.writeUTF(message);
			System.out.println("- Cliente Facebook: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + message + "'");
			
			//Read response (a String) from the server
			String data = in.readUTF();			
			System.out.println("- Cliente de Facebook: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
		} catch (Exception e) {
			System.out.println("# Cliente de Facebook: Error: " + e.getMessage());
		}
	}
	
	public static GateWayFacebook getGateWay() {
		if(gateWay == null) {
			gateWay = new GateWayFacebook();
		}
		return gateWay;
	}
	
	@Override
	public boolean login(String mail, String contr) throws RemoteException {
		
		if (args.length < 2) {
		System.err.println(" # Usando: TCPSocketClient [SERVER IP] [PORT] [MESSAGE]");
		System.exit(1);
		}

		//args[0] = Server IP
		String serverIP = args[0];
		//args[1] = Server socket port
		int serverPort = Integer.parseInt(args[1]);

		/**
		* NOTE: try-with resources Statement - https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		* Try statement that declares one or more resources. A resource is an object that must be closed after the program is
		* finished with it. The try-with-resources statement ensures that each resource is closed at the end of the statement.
		* Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable,
		* can be used as a resource.
		*/

		//Declaration of the socket to send/receive information to/from the server (an IP and a Port are needed)
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
		//Streams to send and receive information are created from the Socket
		    DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
		DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){

		//Send request (a Srting) to the server
		out.writeUTF(mail);
		out.writeUTF(contr);
		System.out.println("- Cliente de Strava: Mandado datos a  '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + mail + " : " + contr + "'");

		//Read response (a String) from the server
		String data = in.readUTF();
		System.out.println("- Cliente de Strava: Reciviendo los datos desde  '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
		if(data.equals("true")) {
			return true;
		}
			return false;
		} catch (Exception e) {
			System.out.println("# Cliente de Strava: Error: " + e.getMessage());
			return false;
		}
		
	}
	
}
