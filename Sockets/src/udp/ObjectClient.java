package udp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ObjectClient {

    public static void main(String[] args) {

        InetAddress addr;
        try {
            addr = InetAddress.getByName("localhost");
            int port = 12345;
            Pessoa joao = new Pessoa("João Grandão", 45);

            System.out.println("enviando objeto...");

            ByteArrayOutputStream objArray = new ByteArrayOutputStream();
            ObjectOutputStream objOutput = new ObjectOutputStream(objArray);
            objOutput.flush();
            objOutput.writeObject(joao);
            objOutput.close();
            
            byte[] msg = objArray.toByteArray();

            DatagramPacket pkg = new DatagramPacket(msg, msg.length, addr, port);
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.send(pkg);
            System.out.println("Objeto enviado para " + addr.getHostAddress() + ":" + port + "\n");
            datagramSocket.close();
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

    }
}
