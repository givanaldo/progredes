package tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	
    public static void main(String[] args) {

        int port = 9999;
        ServerSocket servidor;

        try {
            servidor = new ServerSocket(port);
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.printf("Servidor %s aguardando conexão na porta 9999\n", ip);

            while (true) {
                Socket cliente = servidor.accept();
                String ipCliente = cliente.getInetAddress().getHostAddress();
                System.out.println("Nova conexão com o cliente " + ipCliente);              
                
                Scanner teclado = new Scanner(System.in);
                Scanner entrada = new Scanner(cliente.getInputStream());
                PrintStream saida = new PrintStream(cliente.getOutputStream());
                
                while (entrada.hasNextLine()) {
                    String mensagem = entrada.nextLine();
                    if (mensagem.equals("sair"))
                    		break;
                    System.out.println("cliente: " + mensagem);             
                    System.out.print("servidor: ");
                    saida.println(teclado.nextLine());
                }
                teclado.close();
                entrada.close();
                saida.close();
                cliente.close();
                //servidor.close();
                System.out.println("Conexão finalizada. Aguardando nova conexão...");
            }
        } catch (IOException ex) {
            System.out.println("Erro ao abrir socket do servidor.");
        }
    }
}
