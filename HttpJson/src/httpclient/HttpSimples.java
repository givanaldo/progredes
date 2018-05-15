package httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpSimples {
	
	public static void main(String[] args) {

        // Criando uma conexao HTTP para acessar uma página
        // DefaultHttpClient client = new DefaultHttpClient(); -- deprecated
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            // Pegar conteúdo que está no endereço
            HttpGet page = new HttpGet("http://www.ifrn.edu.br");
            //HttpGet page = new HttpGet("http://worldcup.sfg.io/matches");
            //HttpGet page = new HttpGet("http://educacao.dadosabertosbr.com/api/cidades/rn");            
            // Executando a conexão para a página solicitada
            HttpResponse response = client.execute(page);
            // A resposta da conexão vem no formato de Entity
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // Pega conteúdo da página requisitada e exibe.
                String conteudo = EntityUtils.toString(entity);
                System.out.println(conteudo);
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
    }
}
