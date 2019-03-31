package httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpJsonSaude {

	private static String readUrl(String url) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet page = new HttpGet(url);
        HttpResponse response = client.execute(page);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }
	
	public static void main(String[] args) {

        String url = "http://i3geo.saude.gov.br/i3geo/ogc.php?service=WFS&version=1.0.0&request=GetFeature&typeName=upa_funcionamento_cnes&outputFormat=JSON";
        try {
            JSONObject features = new JSONObject(readUrl(url));
            JSONArray arrayFeatures = features.getJSONArray("features");
            for (int i = 0; i < arrayFeatures.length(); i++) {
                JSONObject objUpas = arrayFeatures.getJSONObject(i);
                JSONArray arrayUpas = objUpas.getJSONArray("properties");
                
                String nomeFantasia = arrayUpas.getJSONObject(4).getString("no_fantasia");
                String cidade = arrayUpas.getJSONObject(3).getString("cidade");
                String uf = arrayUpas.getJSONObject(2).getString("uf");
                String bairro = arrayUpas.getJSONObject(5).getString("no_bairro");
                String fone = arrayUpas.getJSONObject(8).getString("nu_telefone");
                
                System.out.printf("%s (%s - %s) \nBairro: %s - Telefone: %s \n\n", 
                    nomeFantasia, cidade, uf, bairro, fone);
            }            
        } catch (JSONException e) {
            System.out.println("Erro JSON: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
        }
    }
}
