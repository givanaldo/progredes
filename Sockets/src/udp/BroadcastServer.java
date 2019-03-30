package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BroadcastServer {

	public static void main(String[] args) {

		DatagramSocket dgramsocket = null;
		try {
			int porta = 22888;
			byte[] msg = new byte[1];
			dgramsocket = new DatagramSocket();
			dgramsocket.setBroadcast(true);
			System.out.println("...servidor online...");

			while (true) {
				msg[0] = (byte) (Math.random() * 50);
				DatagramPacket pkg = new DatagramPacket(msg, msg.length, InetAddress.getByName("10.209.255.255"), porta);
				dgramsocket.send(pkg);
				System.out.println("enviando via broadcast --> " + msg[0]);
				Thread.sleep(3000);
			}
		} catch (IOException | InterruptedException ex) {
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			dgramsocket.close();
		}
	}
}
