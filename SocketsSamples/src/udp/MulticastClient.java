package udp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {

	public static void main(String[] args) {

		int porta = 12123;
		String hostMulticast = "239.0.0.1";
		MulticastSocket multicastSocket = null;
		while (true) {
			try {
				multicastSocket = new MulticastSocket(porta);
				InetAddress grupoMulticast = InetAddress.getByName(hostMulticast);
				multicastSocket.joinGroup(grupoMulticast);
				byte msg[] = new byte[256];
				DatagramPacket pkg = new DatagramPacket(msg, msg.length);
				multicastSocket.receive(pkg);
				String dados = new String(pkg.getData());
				System.out.println("Dados recebidos:" + dados);
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			} finally {
				multicastSocket.close();
			}
		}
	}
}
