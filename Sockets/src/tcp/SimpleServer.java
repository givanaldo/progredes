package tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServer {
    public static void main(String[] args) {

        int porta = 9999;
        ServerSocket servidor;

        try {
            servidor = new ServerSocket(porta);
            
            String ip = InetAddress.getByName("localhost").getHostAddress();
            byte[] ipVec = InetAddress.getByName("localhost").getAddress();
            String host = InetAddress.getByAddress(ipVec).getHostName();            
            

            while (true) {
                System.out.printf("Servidor %s (%s) aguardando conexão na porta 9999\n", host, ip);
                Socket cliente = servidor.accept();

                // conectou!!!
                System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

                // Stream para receber dados do cliente
                Scanner entrada = new Scanner(cliente.getInputStream());
                
                while (entrada.hasNextLine()) {
                    String texto = entrada.nextLine();
                    System.out.println("texto recebido: " + texto);
                }
                
                entrada.close();
                cliente.close();
                //servidor.close();
                System.out.println("Conexão finalizada");
            }
        } catch (IOException ex) {
            System.out.println("Erro ao abrir socket do servidor.");
        }
    }

}
