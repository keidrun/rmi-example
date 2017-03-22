/**
 * Copyright (c) 2015, Keid All rights reserved.
 */
package rmi.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Remote object implementation
 * @author keid
 */
public class MessengerImpl extends UnicastRemoteObject implements Messenger{

	/**
	 * constructor of UnicastRemoteObject
	 * @throws RemoteException
	 */
	public MessengerImpl() throws RemoteException {
		super();
	}

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 1L;

}
