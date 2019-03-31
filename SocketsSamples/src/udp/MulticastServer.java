package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MulticastServer {

	public static void main(String[] args) {

		String mensagem;
		int porta = 12123;
		String hostMulticast = "239.0.0.1";
		DatagramSocket udpsocket = null;
		Scanner teclado = null;
		while (true) {
			try {
				teclado = new Scanner(System.in);
				mensagem = teclado.nextLine();
				byte[] msg = mensagem.getBytes();
				InetAddress addr = InetAddress.getByName(hostMulticast);
				udpsocket = new DatagramSocket();
				DatagramPacket pkg = new DatagramPacket(msg, msg.length, addr, porta);
				udpsocket.send(pkg);
			} catch (Exception e) {
				System.out.println("Não foi possível enviar a mensagem.");
			} finally {
				udpsocket.close();
				teclado.close();
			}
		}
	}
}
