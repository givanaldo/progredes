package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientChat {

    public static void main(String[] args) throws UnknownHostException, IOException {
        teclado = new Scanner(System.in);
        System.out.print("Usuário: ");
        String nomeCliente = teclado.nextLine();
        new ClientChat("127.0.0.1", 12345, nomeCliente).executa();
    }

    private String host;
    private int porta;
    private String nome;
	private static Scanner teclado;

    public ClientChat(String host, int porta, String nome) {
        this.host = host;
        this.porta = porta;
        this.nome = nome;
    }

    public void executa() throws UnknownHostException, IOException {
        Socket cliente = new Socket(this.host, this.porta);
        System.out.println("O cliente se conectou ao servidor!");

        // thread para receber mensagens do servidor
        ReceptorChat receptor = new ReceptorChat(cliente.getInputStream());
        new Thread(receptor).start();

        // lê msgs do teclado e manda pro servidor
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        while (teclado.hasNextLine()) {
            saida.println(nome + ": " + teclado.nextLine());
        }
        
        saida.close();
        teclado.close();
        cliente.close();
    }
}
