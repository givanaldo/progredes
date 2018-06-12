package gson;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGson {

    private static String readUrl(String url) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet page = new HttpGet(url);
        HttpResponse response = client.execute(page);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }

    public static void main(String[] args) {
        try {
            String url = "http://worldcup.sfg.io/matches";
            String jsonFile = readUrl(url);
            Gson gson = new Gson();
            Match[] matches = gson.fromJson(jsonFile, Match[].class);
            for (Match match : matches) {
                int matchNumber = match.getMatchNumber();
                String location = match.getLocation();
                String homeTeam = match.getHomeTeam().getCountry();
                int homeTeamGoals = match.getHomeTeam().getGoals();
                String awayTeam = match.getAwayTeam().getCountry();
                int awayTeamGoals = match.getAwayTeam().getGoals();

                // Exibir apenas os jogos do Brasil
                if (homeTeam.equals("Brazil") || awayTeam.equals("Brazil")) {
                    System.out.printf("Jogo %d: %s %d x %d %s [%s] \n",
                            matchNumber, homeTeam, homeTeamGoals, awayTeamGoals, awayTeam, location);
                    System.out.println(homeTeam + ": ");                    
                    for (Event homeEvent : match.getHomeTeamEvents()) {
                        String tipo = homeEvent.getType();
                        String jogador = homeEvent.getPlayer();
                        String tempo = homeEvent.getTime();
                        System.out.printf("-- %s, %s, %s\n", tipo, jogador, tempo);
                    }
                    System.out.println(awayTeam + ": ");
                    for (Event awayEvent : match.getAwayTeamEvents()) {
                        String tipo = awayEvent.getType();
                        String jogador = awayEvent.getPlayer();
                        String tempo = awayEvent.getTime();
                        System.out.printf("-- %s, %s, %s\n", tipo, jogador, tempo);
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
