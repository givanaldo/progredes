package tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {

		int port = 9999;
		String ipServidor = "localhost";

		Socket servidor = new Socket(ipServidor, port);
		System.out.println("O cliente se conectou ao servidor! Iniciando chat...");

		Scanner teclado = new Scanner(System.in);
		Scanner entrada = new Scanner(servidor.getInputStream());
		PrintStream saida = new PrintStream(servidor.getOutputStream());
		String mensagem;
		System.out.print("cliente: ");
		while (teclado.hasNextLine()) {			
			mensagem = teclado.nextLine();
			if (mensagem.equals("sair"))
				break;
			saida.println(mensagem);
			mensagem = entrada.nextLine();
			System.out.println("servidor: " + mensagem);
			System.out.print("cliente: ");
		}
		entrada.close();
		saida.close();
		teclado.close();
		servidor.close();
		System.out.println("Conexão finalizada.");
	}
}
