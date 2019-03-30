package tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author givanaldo
 *
 */
public class TestInetAddress {
	
	public static void main(String[] args) {
		String site = "www.ifrn.edu.br";
		try {
			byte[] ip = InetAddress.getByName(site).getAddress();
			System.out.println("IP: " + ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3]);

			String otherIp = InetAddress.getByName(site).getHostAddress();
			System.out.println("IP: " + otherIp);

			byte[] uol = { -56, -119, 2, -126 };
			String hostUol = InetAddress.getByAddress(uol).getHostName();
			System.out.println("Hostname: " + hostUol);

			byte[] localhost = { 127, 0, 0, 1 };
			String host = InetAddress.getByAddress(localhost).getHostName();
			System.out.println("Hostname: " + host);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
