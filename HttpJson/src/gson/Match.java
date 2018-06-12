package gson;

import java.util.ArrayList;

public class Match {
    private int match_number;
    private String location;
    private String datetime;
    private String status;
    private Team home_team;
    private Team away_team;
    private String winner;
    private String winner_code;
    private ArrayList<Event> home_team_events;
    private ArrayList<Event> away_team_events;

    @Override
    public String toString() {
        return "Match{" + "matchNumber=" + match_number + ", location=" + location + ", dateTime=" + datetime + ", status=" + status + ", homeTeam=" + home_team + ", awayTeam=" + away_team + ", winner=" + winner + ", winnerCode=" + winner_code + ", homeTeamEvents=" + home_team_events + ", awayTeamEvents=" + away_team_events + '}';
    }

    public int getMatchNumber() {
        return match_number;
    }

    public String getLocation() {
        return location;
    }

    public String getDateTime() {
        return datetime;
    }

    public String getStatus() {
        return status;
    }

    public Team getHomeTeam() {
        return home_team;
    }

    public Team getAwayTeam() {
        return away_team;
    }

    public String getWinner() {
        return winner;
    }

    public String getWinnerCode() {
        return winner_code;
    }

    public ArrayList<Event> getHomeTeamEvents() {
        return home_team_events;
    }

    public ArrayList<Event> getAwayTeamEvents() {
        return away_team_events;
    }    
}
