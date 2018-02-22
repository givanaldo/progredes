package tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	public static void main(String[] args) {

		try {
			byte[] ip = InetAddress.getByName("www.uol.com").getAddress();
			System.out.println("IP: " + ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3]);

			String otherIp = InetAddress.getByName("www.globo.com").getHostAddress();
			System.out.println("IP: " + otherIp);

			byte[] globo = { -56, -109, 3, -57 };
			String hostUol = InetAddress.getByAddress(globo).getHostName();
			System.out.println("Hostname: " + hostUol);

			byte[] localhost = { 127, 0, 0, 1 };
			String host = InetAddress.getByAddress(localhost).getHostName();
			System.out.println("Hostname: " + host);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
