package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SimpleServer {

    public static void main(String[] args) {

        DatagramSocket dgramsocket;
        DatagramPacket dgrampack;
        int porta = 12345;

        while (true) {
            try {
                System.out.println("Servidor UDP. Aguardando mensagem...");
                dgramsocket = new DatagramSocket(porta);
                byte[] msg = new byte[512];
                dgrampack = new DatagramPacket(msg, msg.length);
                dgramsocket.receive(dgrampack);
                System.out.println("Mensagem: " + new String(dgrampack.getData()));
                dgramsocket.close();
            } catch (IOException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }
}
