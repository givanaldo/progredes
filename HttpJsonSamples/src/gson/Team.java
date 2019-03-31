package gson;

public class Team {
    private String country;
    private String code;
    private int goals;

    @Override
    public String toString() {
        return "Team{" + "country=" + country + ", code=" + code + ", goals=" + goals + '}';
    }

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

    public int getGoals() {
        return goals;
    }
}
