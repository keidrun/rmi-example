/**
 * Copyright (c) 2015, Keid All rights reserved.
 */
package rmi.client;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

/**
 * Rmi client
 * @author keid
 */
public interface RmiClient {
		
	/**
	 * lookup remote object
	 * @return remote object
	 * @throws RemoteException
	 * @throws NotBoundException
	 * @throws MalformedURLException
	 */
	public Remote lookup() throws RemoteException, NotBoundException, MalformedURLException;
	
	/**
	 * lookup via Registry
	 * @param host
	 * @param port
	 * @param serverName
	 * @return remote object
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public default Remote lookup(String host, int port, String serverName) throws RemoteException, NotBoundException{
		
		// rmi url
		String url = "rmi://"+ host + ":" + Integer.toString(port) +"/" + serverName;
						
		// lookup remote object from rmiregistry
		System.out.println("lookup \"" + url + "\" from rmiregistry");	
		Registry rmiregistry = LocateRegistry.getRegistry(port);

		return rmiregistry.lookup(url);
	
	}
	
	/**
	 * lookup via rmiregistry process
	 * @param host
	 * @param port
	 * @param serverName
	 * @return remote object
	 * @throws RemoteException
	 * @throws NotBoundException
	 * @throws MalformedURLException
	 */
	public default Remote lookupViaProcess(String host, int port, String serverName) throws RemoteException, NotBoundException, MalformedURLException{
		
		// rmi url
		String url = "rmi://"+ host + ":" + Integer.toString(port) +"/" + serverName;
						
		// lookup remote object from rmiregistry
		System.out.println("lookup \"" + url + "\" from rmiregistry");	

		return Naming.lookup(url);
	
	}

}
