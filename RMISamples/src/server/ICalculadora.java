package server;

import java.rmi.RemoteException;

public interface ICalculadora extends java.rmi.Remote {
    double soma(double a, double b) throws RemoteException;
    double subtracao(double a, double b) throws RemoteException;
}
