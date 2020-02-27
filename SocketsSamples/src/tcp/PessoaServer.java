package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PessoaServer {

    public static void main(String[] args) {
        ServerSocket servidor = null;
        try {
            servidor = new ServerSocket(12345);
            System.out.println("Servidor escutando a porta 12345");
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                Pessoa pessoa = (Pessoa) entrada.readObject();
                System.out.println(pessoa);
                entrada.close();
                cliente.close();
            }
        } catch (Exception e) {
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
