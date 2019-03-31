package tcpthreads;

import java.io.*;
import java.net.*;

public class TratamentoThread implements Runnable {

    Socket SockCliente;
    String name;
    
    public TratamentoThread(String nameThread, Socket Cliente) {
        name = nameThread;
        SockCliente = Cliente;
    }
    
    @Override
    public void run() {
        String Entrada = "INÍCIO";
        try {
            PrintWriter escritor = new PrintWriter(SockCliente.getOutputStream(), true);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(SockCliente.getInputStream()));
            while (!Entrada.equals("FIM")) {
                Entrada = lerDados(leitor);
                if (!Entrada.equals("FIM")) {
                    dadosCliente(SockCliente);
                    System.out.println("\tMensagem: " + Entrada);
                    enviarDados(Entrada, escritor);
                }
            }
            SockCliente.close();
            escritor.close();
            leitor.close();
        } catch (IOException e) {
            System.out.println("Falha: " + e.toString());
            System.exit(0);
        }
    }

    public void enviarDados(String saida, PrintWriter escritor) {
    		ServerStatus conf = new ServerStatus(name);
        escritor.println("Recebeu: " + saida + "\nServidor: " + conf.toString());
    }

    public String lerDados(BufferedReader leitor) throws IOException {
        String dados = null;
        try {
            dados = leitor.readLine();
        } catch (Exception e) {
            System.out.println("Falha : " + e.toString());
            System.exit(0);
        }
        return dados;
    }

    public void dadosCliente(Socket s) {
        System.out.println("\nRecebeu uma mensagem do cliente:\n\tporta remota: " + s.getPort());
        System.out.println("\tporta local: " + s.getLocalPort());
        System.out.println("\tCliente: " + s.getInetAddress());
    }

}
