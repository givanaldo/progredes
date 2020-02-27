package tcp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class PessoaClient {

    private static Scanner teclado;

    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("localhost", 12345);
            teclado = new Scanner(System.in);
            System.out.println("Nome: ");
            String nome = teclado.nextLine();
            System.out.println("Idade: ");
            int idade = teclado.nextInt();
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            saida.flush();
            saida.writeObject(new Pessoa(nome, idade));
            saida.close();
            cliente.close();
            System.out.println("Objeto enviado com êxito");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
