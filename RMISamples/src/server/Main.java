package server;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) {
        try {
            Calculadora calc = new Calculadora();
            Servidor servidor = new Servidor(calc, "localhost", "Calc");
        }
        catch (IllegalAccessException | InstantiationException | RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }    
}
