package tcpthreads;

import java.net.*;
import java.io.*;

public class TcpThreadClient {

    public static void main(String[] args) throws IOException {

        Socket cliente = null;
        PrintWriter escritor = null;
        BufferedReader leitor = null;
        String DatosEnviados = null;
        String servidor = "localhost";
        int porta = 4499;

        BufferedReader DatosTeclado = new BufferedReader(new InputStreamReader(System.in));

        try {
            cliente = new Socket(servidor, porta);
            System.out.println("Conectado a " + servidor + " na porta: " + porta);
        } catch (IOException e) {
            System.out.println("Falha : " + e.getMessage());
            System.exit(0);
        }

        try {
            escritor = new PrintWriter(cliente.getOutputStream(), true);
            leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        } catch (IOException e) {
            System.out.println("Falha : " + e.getMessage());
            cliente.close();
            System.exit(0);
        }
        
        do {
            System.out.println("Envie uma mensagem para receber dados do servidor:");
            System.out.print(">> ");
            DatosEnviados = DatosTeclado.readLine();
            escritor.println(DatosEnviados);
            if (!DatosEnviados.equals("FIM")) {
                System.out.println(leitor.readLine());
                System.out.println(leitor.readLine());
                System.out.println(leitor.readLine());
                System.out.println(leitor.readLine());
                System.out.println(leitor.readLine());
            }
        } while (!DatosEnviados.equals("FIM"));

        System.out.println("Finalizada conexão com o servidor.");

        try {
            escritor.close();
        } catch (Exception e) {
            System.out.println("Falha : " + e.getMessage());
        }
    }
}
