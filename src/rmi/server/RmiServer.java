/**
 * Copyright (c) 2015, Keid All rights reserved.
 */
package rmi.server;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

import java.rmi.RemoteException;
import java.net.MalformedURLException;

/**
 * Rmi server
 * @author keid
 */
public interface RmiServer{

	/**
	 * start server
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public void start() throws RemoteException, MalformedURLException;
	
	/**
	 * start server via Registry
	 * @param host
	 * @param port
	 * @param serverName
	 * @param remoteObject
	 * @throws RemoteException
	 */
	public default void start(String host, int port, String serverName, Remote remoteObject) throws RemoteException{
		
		// rmi url
		String url = "rmi://"+ host + ":" + Integer.toString(port) +"/" + serverName;
						
		// bind remote object to rmiregistry
		System.out.println("bind \"" + url + "\" to rmiregistry");			
		Registry rmiregistry = LocateRegistry.createRegistry(port);
		rmiregistry.rebind(url, remoteObject);

		//LocateRegistry.createRegistry(port);

//		LocateRegistry.createRegistry(port);
//		try {
//			Naming.rebind(url, remoteObject);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//		
//		String[] names = rmiregistry.list(); 
//	    for(String name1 : names){ 
//	        System.out.println("~~~~" + name1 + "~~~~"); 
//	    } 
		
		System.out.println("Rmi server starting...");
			
	}

	/**
	 * start server via rmiregistry process
	 * @param host
	 * @param port
	 * @param serverName
	 * @param remoteObject
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public default void startViaProcess(String host, int port, String serverName, Remote remoteObject) throws RemoteException, MalformedURLException{
		
		// rmi url
		String url = "rmi://"+ host + ":" + Integer.toString(port) +"/" + serverName;
						
		// bind remote object to rmiregistry
		System.out.println("bind \"" + url + "\" to rmiregistry");
		Naming.rebind(url, remoteObject);

		System.out.println("Rmi server starting...");
			
	}
	
}
