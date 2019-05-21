package gson;

import com.google.gson.Gson;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Estatisticas {

	// Method for sorting the TreeMap based on values
	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};

		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	private static String readUrl(String url) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet page = new HttpGet(url);
		HttpResponse response = client.execute(page);
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity);
	}

	public static void main(String[] args) {

		HashMap<String, Integer> mapGoals = new HashMap<>();
		HashMap<String, Integer> mapYellow = new HashMap<>();
		HashMap<String, Integer> mapRed = new HashMap<>();

		try {
			String url = "http://worldcup.sfg.io/matches";
			String jsonFile = readUrl(url);
			Gson gson = new Gson();
			Match[] matches = gson.fromJson(jsonFile, Match[].class);
			for (Match match : matches) {
				String homeTeam = match.getHomeTeam().getCountry();
				for (Event homeEvent : match.getHomeTeamEvents()) {
					String tipo = homeEvent.getType();
					String jogador = homeEvent.getPlayer();

					if (tipo.equals("goal") || tipo.equals("goal-penalty")) {
						String chave = jogador + " (" + homeTeam + ")";
						if (mapGoals.containsKey(chave))
							mapGoals.put(chave, mapGoals.get(chave) + 1);
						else
							mapGoals.put(chave, 1);
					}
					
					if (tipo.equals("yellow-card")) {
						String chave = jogador + " (" + homeTeam + ")";
						if (mapYellow.containsKey(chave))
							mapYellow.put(chave, mapYellow.get(chave) + 1);
						else
							mapYellow.put(chave, 1);
					}
					
					if (tipo.equals("red-card")) {
						String chave = jogador + " (" + homeTeam + ")";
						if (mapRed.containsKey(chave))
							mapRed.put(chave, mapRed.get(chave) + 1);
						else
							mapRed.put(chave, 1);
					}
				}
				String awayTeam = match.getAwayTeam().getCountry();
				for (Event awayEvent : match.getAwayTeamEvents()) {
					String tipo = awayEvent.getType();
					String jogador = awayEvent.getPlayer();
					// String tempo = awayEvent.getTime();
					// System.out.printf("-- %s, %s, %s\n", tipo, jogador, tempo);

					if (tipo.equals("goal") || tipo.equals("goal-penalty")) {
						String chave = jogador + " (" + awayTeam + ")";
						if (mapGoals.containsKey(chave))
							mapGoals.put(chave, mapGoals.get(chave) + 1);
						else
							mapGoals.put(chave, 1);
					}
					
					if (tipo.equals("yellow-card")) {
						String chave = jogador + " (" + awayTeam + ")";
						if (mapYellow.containsKey(chave))
							mapYellow.put(chave, mapYellow.get(chave) + 1);
						else
							mapYellow.put(chave, 1);
					}
					if (tipo.equals("red-card")) {
						String chave = jogador + " (" + awayTeam + ")";
						if (mapRed.containsKey(chave))
							mapRed.put(chave, mapRed.get(chave) + 1);
						else
							mapRed.put(chave, 1);
					}
				}
			}

			Map<String, Integer> sortedMapGoals = sortByValues(mapGoals);
			Map<String, Integer> sortedMapYellow = sortByValues(mapYellow);
			Map<String, Integer> sortedMapRed = sortByValues(mapRed);
			
			System.out.println("\nArtilharia:");
			for (String jogador : sortedMapGoals.keySet())
				System.out.println(jogador + ": " + mapGoals.get(jogador));
			System.out.println("\n\nCartões amarelos:");
			for (String jogador : sortedMapYellow.keySet())
				System.out.println(jogador + ": " + mapYellow.get(jogador));
			System.out.println("\n\nCartões Vermelhos:");
			for (String jogador : sortedMapRed.keySet())
				System.out.println(jogador + ": " + mapRed.get(jogador));

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
