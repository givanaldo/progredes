package httpclient;

public class Event {
    private int id;
    private String type_of_event;
    private String player;
    private String time;

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", type=" + type_of_event + ", player=" + player + ", time=" + time + '}';
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type_of_event;
    }

    public String getPlayer() {
        return player;
    }

    public String getTime() {
        return time;
    }
}
