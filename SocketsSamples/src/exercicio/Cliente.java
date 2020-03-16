package exercicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Cliente {

    public static String nomeArquivo = "arquivo-cliente.txt";

    public static void main(String[] args) {

        try {
            
            //-System.out.println(System.getProperty("user.dir"););
            
            File arquivo = new File("/Users/Downloads/" + nomeArquivo);
            FileInputStream arquivoStream = new FileInputStream(arquivo);

            Socket cliente = new Socket("localhost", 5555);
            System.out.printf("O cliente se conectou ao servidor.");

            OutputStream saida = cliente.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(saida);
            BufferedWriter writer = new BufferedWriter(osw);
            
            writer.write(arquivo + "\n");
            writer.flush();
            int tamanho = 4096;
            byte[] buffer = new byte[4096];
            int lidos = -1;
            
            while ((lidos = arquivoStream.read(buffer, 0, tamanho)) != -1) {
                saida.write(buffer, 0, lidos);
            }
            cliente.close();
        } catch (IOException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }
}
