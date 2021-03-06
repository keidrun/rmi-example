/**
 * Copyright (c) 2015, Keid All rights reserved.		
 */
package rmi.client;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.remote.Messenger;

/**
 * Rmi client implementation
 * @author keid
 */
public class RmiClientImpl implements RmiClient{
	
	private String host;
	private int port;
	private String serverName;
	
	public RmiClientImpl(String host, int port, String serverName){
		this.host = host;
		this.port = port;
		this.serverName = serverName;
	}
	
	@Override
	public Remote lookup() throws RemoteException, NotBoundException, MalformedURLException{
		return lookup(host, port, serverName);
		//return lookupViaProcess(host, port, serverName);
	}
	
	/**
	 * client main program
	 * @param args
	 */
	public static void main(String[] args){
		
		String message = "Hey, Keid!";
		
		try {
			
			//String host = "localhost";
			String host = InetAddress.getLocalHost().getHostAddress();
			int port = 1099;
			String serverName = "server";
			
			RmiClient client = new RmiClientImpl(host, port, serverName);
			Messenger messenger = (Messenger) client.lookup();
			System.out.println(messenger.send(message));
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
