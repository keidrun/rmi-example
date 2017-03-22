/**
 * Copyright (c) 2015, Keid All rights reserved.
 */
package rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote object
 * @author keid
 */
public interface Messenger extends Remote{
	
	/**
	 * send client's message
	 * @param message
	 * @return client's message
	 * @throws RemoteException
	 */
	public default String send(String message) throws RemoteException{
		System.out.println("client says \"" + message + "\".");
		return "send \"" + message + "\" to server.";
	}
	
}
