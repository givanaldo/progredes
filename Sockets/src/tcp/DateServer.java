package tcp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
	public static void main(String[] args) {
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(12345);
			System.out.println("Servidor escutando a porta 12345");
			while (true) {
				Socket cliente = servidor.accept();
				System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
				ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
				Date dataServidor = new Date();
				saida.writeObject(dataServidor);
				saida.flush();
				saida.close();
				cliente.close();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			try {
				servidor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
