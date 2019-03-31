package udp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ObjectServer {

    public static void main(String[] args) {

        DatagramSocket serverdgram;
        DatagramPacket pkg;

        while (true) {
            try {
                System.out.println("Aguardando objeto...");
                serverdgram = new DatagramSocket(12345);
                byte[] msg = new byte[256];
                pkg = new DatagramPacket(msg, msg.length);
                serverdgram.receive(pkg);

                ByteArrayInputStream objArray = new ByteArrayInputStream(pkg.getData());
                ObjectInputStream objStream = new ObjectInputStream(objArray);
                Pessoa pessoa = (Pessoa) objStream.readObject();

                System.out.println("Objeto: " + pessoa.toString());
                serverdgram.close();
            } catch (SocketException ex) {
                System.out.println("Erro: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Erro: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }

}
