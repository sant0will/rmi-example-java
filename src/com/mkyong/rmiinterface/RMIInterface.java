package com.mkyong.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
	public String helloTo(String name) throws RemoteException;
	public double add(int x, int y) throws RemoteException;
	public double sub(int x, int y) throws RemoteException;
	public double mul(int x, int y) throws RemoteException;
	public double div(int x, int y) throws RemoteException;
	public double exp(int x, int y) throws RemoteException;
}