package interfaces;

import java.rmi.RemoteException;

public interface ICalculadora extends java.rmi.Remote {
    double soma(double a, double b) throws RemoteException;
    double subtracao(double a, double b) throws RemoteException;
    double multiplicacao(double a, double b) throws RemoteException;
    double divisao(double a, double b) throws RemoteException;
    double exponenciacao(double a, double b) throws RemoteException;
}
