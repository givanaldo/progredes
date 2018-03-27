package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerChat {

    public static void main(String[] args) throws IOException {
        // inicia o servidor
        new ServerChat(12345).executa();
    }

    private int porta;
    // array de streams dos clientes conectados
    private List<PrintStream> clientes;

    public ServerChat(int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<>();
    }

    public void executa() throws IOException {
        ServerSocket servidor = new ServerSocket(this.porta);
        System.out.println("Porta 12345 aberta!");

        while (true) {
            // aceita um cliente
            Socket cliente = servidor.accept();

            System.out.println("Nova conexão com o cliente "
                    + cliente.getInetAddress().getHostAddress());

            // adiciona saida do cliente à lista
            PrintStream ps = new PrintStream(cliente.getOutputStream());

            this.clientes.add(ps);

            // cria tratador de cliente numa nova thread
            TrataClienteChat tc = new TrataClienteChat(cliente.getInputStream(), this);
            new Thread(tc).start();
        }
    }

    public void distribuiMensagem(String msg) {

        // envia mensagem para todos os clientes
        for (PrintStream cliente : this.clientes) {
            cliente.println(msg);
        }
    }
    
    public void clientesConectados() {
        // listar os clientes conectados
        // TO DO
    }
}
