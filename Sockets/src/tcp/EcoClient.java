package tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EcoClient {

    public static void main(String[] args) throws UnknownHostException, IOException {
        
        int port = 5000;
        String ipServidor = "localhost";
        
        Socket cliente = new Socket(ipServidor, port);
        System.out.println("O cliente se conectou ao servidor!");
        
        Scanner teclado = new Scanner(System.in);
        Scanner entrada = new Scanner(cliente.getInputStream());
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        System.out.print("texto para enviar: ");
        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
            System.out.print("Enviado pelo servidor: ");
            System.out.println(entrada.nextLine());
            System.out.print("texto para enviar: ");
        }
        saida.close();
        entrada.close();
        teclado.close();
        cliente.close();
    }
}
