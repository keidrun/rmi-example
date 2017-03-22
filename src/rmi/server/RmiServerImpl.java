/**
 * Copyright (c) 2015, Keid All rights reserved.
 */
package rmi.server;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.remote.Messenger;
import rmi.remote.MessengerImpl;

/**
 * Rmi server implementation
 * @author keid
 */
public class RmiServerImpl implements RmiServer{

	private String host;
	private int port;
	private String serverName;
	private Remote remoteObject;

	public RmiServerImpl(String host, int port, String serverName, Remote remoteObject){
		this.host = host;
		this.port = port;
		this.serverName = serverName;
		this.remoteObject = remoteObject;
	}
	
	@Override
	public void start() throws RemoteException, MalformedURLException{
		start(host, port, serverName, remoteObject);
		//startViaProcess(host, port, serverName, remoteObject);
	}
		
	/**
	 * server main program
	 * @param args
	 */
	public static void main(String[] args){
				
		try {

			//String host = "localhost";
			String host = InetAddress.getLocalHost().getHostAddress();
			int port = 1099;
			String serverName = "server";
			Messenger messenger = new MessengerImpl();

			RmiServer server = new RmiServerImpl(host, port, serverName, messenger);
			server.start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
