package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadcastClient {

    public static void main(String[] args) {
        DatagramSocket udpsocket;
        try {
            int porta = 22888;
            byte[] msg = new byte[1];

            udpsocket = new DatagramSocket(porta);
            udpsocket.setBroadcast(true);
            System.out.println("...cliente online...");

            while (true) {
                DatagramPacket pkg = new DatagramPacket(msg, msg.length);
                udpsocket.receive(pkg);
                msg = pkg.getData();
                System.out.println("recebido via broadcast --> " + msg[0]);
            }
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
