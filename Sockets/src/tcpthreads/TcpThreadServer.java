package tcpthreads;

import java.net.*;
import java.io.*;

public class TcpThreadServer {

	public static void main(String[] argumentos) throws IOException {

		int porta = 4499;
		ServerSocket socketServidor = null;
		Socket socketCliente = null;

		try {
			socketServidor = new ServerSocket(porta);
		} catch (IOException e) {
			System.out.println("Falha : " + e.toString());
			System.exit(0);
		}

		System.out.println("Servidor iniciado... (Socket TCP)");

		try {
			while (true) {
				socketCliente = socketServidor.accept();
				TratamentoThread clienteThread = new TratamentoThread("Cliente:  " + socketCliente.toString(), socketCliente);
			}
		} catch (IOException e) {
			System.out.println("Falha : " + e.toString());
			socketServidor.close();
			System.exit(0);
		}

	}
}
