package tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EcoClient {
	public static void main(String[] args) {
        
		int porta = 9999;
        String ipServidor = "127.0.0.1";
        
		try {
			Socket cliente = new Socket(ipServidor, porta);
	        System.out.println("O cliente se conectou ao servidor!");
	        
	        Scanner teclado = new Scanner(System.in);
	        PrintStream saida = new PrintStream(cliente.getOutputStream());
	        System.out.print("texto para enviar: ");
	        while (teclado.hasNextLine()) {
	            saida.println(teclado.nextLine());
	            Scanner entrada = new Scanner(cliente.getInputStream());
	            System.out.print("Enviado pelo servidor: ");
	            System.out.println(entrada.nextLine());
	            System.out.print("texto para enviar: ");
	            entrada.close();
	        }
	        saida.close();
	        teclado.close();
	        cliente.close();

		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
