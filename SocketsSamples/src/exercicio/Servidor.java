package exercicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static String nomeArquivo = "arquivo-servidor.txt";

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(5555);
            System.out.println("Aguardando cliente...");
            Socket clSocket = server.accept();
            System.out.println("Cliente conectado.");
            
            InputStream in = clSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(isr);
            
            String fName = reader.readLine();
            System.out.println(fName);
            
            File f1 = new File("/Users/givanaldo/Downloads/" + nomeArquivo);
            FileOutputStream out = new FileOutputStream(f1);

            int tamanho = 4096;
            byte[] buffer = new byte[tamanho];
            int lidos = -1;
            while ((lidos = in.read(buffer, 0, tamanho)) != -1) {
                System.out.println(lidos);
                out.write(buffer, 0, lidos);
            }
            out.flush();
        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

}
