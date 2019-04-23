package com.mkyong.rmiserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.mkyong.rmiinterface.RMIInterface;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface{
	private static final long serialVersionUID = 1L;

	protected ServerOperation() throws RemoteException {
		super();
	}

	@Override
	public String helloTo(String name) throws RemoteException{
		System.err.println(name + " está tentando se conectar!");
		return "Servidor diz olá para " + name;
	}
	
	@Override
	public double add(int x, int y) throws RemoteException{
		return x + y;
	}
	
	@Override
	public double sub(int x, int y) throws RemoteException{
		return x - y;
	}
	
	@Override
	public double mul(int x, int y) throws RemoteException{
		return x * y;
	}
	
	@Override
	public double div(int x, int y) throws RemoteException{
		return x / y;
	}
	
	@Override
	public double exp(int x, int y) throws RemoteException{
		return Math.pow(x, y);
	}
	
	public static void main(String[] args){
		try {
			Naming.rebind("//localhost/MyServer", new ServerOperation());            
            System.err.println("Servidor pronto...");
            
        } catch (Exception e) {
        	System.err.println("Server exception: " + e.toString());
          e.printStackTrace();
        }
	}
}
