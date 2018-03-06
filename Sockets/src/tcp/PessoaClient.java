package tcp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PessoaClient {

    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("localhost", 12345);
            Pessoa joao = new Pessoa("João Pedro", 18);            
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            saida.flush();
            saida.writeObject(joao);
            saida.close();
            cliente.close();
            System.out.println("Objeto enviado com êxito");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
