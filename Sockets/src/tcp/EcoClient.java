package tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EcoClient {

    public static void main(String[] args) throws UnknownHostException, IOException {
        
        int port = 9999;
        String ipServidor = "127.0.0.1";
        
        Socket cliente = new Socket(ipServidor, port);
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
        }
        saida.close();
        teclado.close();
        cliente.close();
    }
}
