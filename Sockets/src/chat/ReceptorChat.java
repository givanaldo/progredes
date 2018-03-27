package chat;

import java.io.InputStream;
import java.util.Scanner;

public class ReceptorChat implements Runnable {

    private InputStream servidor;

    public ReceptorChat(InputStream servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        // recebe msgs do servidor e imprime na tela
        Scanner teclado = new Scanner(this.servidor);
        while (teclado.hasNextLine()) {
            System.out.println(teclado.nextLine());
        }
    }
}
