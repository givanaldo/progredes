package chat;

import java.io.InputStream;
import java.util.Scanner;

public class ReceptorChat implements Runnable {

    private InputStream servidor;
	private Scanner teclado;

    public ReceptorChat(InputStream servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        teclado = new Scanner(this.servidor);
        while (teclado.hasNextLine()) {
            System.out.println(teclado.nextLine());
        }
    }
}
