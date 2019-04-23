package server;

import java.rmi.RemoteException;

public class Calculadora extends java.rmi.server.UnicastRemoteObject implements ICalculadora {

    public Calculadora() throws RemoteException {
        super();
    }
    
    @Override
    public double soma(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double subtracao(double a, double b) throws RemoteException {
        return a - b;
    }
    
}
