package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import server.ICalculadora;

public class Main {

    public static void main(String[] args) {

        try {
            Cliente<ICalculadora> cliente = new Cliente<>("localhost", "Calc");
            System.out.println(cliente.getRemoteObj().soma(4, 6));
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
