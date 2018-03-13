package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SimpleClient {

    public static void main(String[] args) {

        InetAddress host;
        Scanner teclado = new Scanner(System.in);
        try {
            host = InetAddress.getByName("localhost");
            int porta = 12345;
            
            while (true) {
                System.out.print("Digite a mensagem: ");
                String mensagem = teclado.nextLine();

                byte[] msg = mensagem.getBytes();
                DatagramPacket dgrampack = new DatagramPacket(msg, msg.length, host, porta);
                DatagramSocket dgramsocket = new DatagramSocket();
                dgramsocket.send(dgrampack);
                System.out.println("Mensagem enviada para " + host.getHostAddress()
                        + ":" + porta + "\n");
                dgramsocket.close();
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        teclado.close();
    }
}
