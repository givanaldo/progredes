package chat;

import java.io.InputStream;
import java.util.Scanner;

public class TrataClienteChat implements Runnable {

    private InputStream cliente;
    private ServerChat servidor;

    public TrataClienteChat(InputStream cliente, ServerChat servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    public void run() {

        // quando chegar uma msg, distribui pra todos
        Scanner s = new Scanner(this.cliente);

        while (s.hasNextLine()) {
            servidor.distribuiMensagem(s.nextLine());
        }
        s.close();
    }
}
