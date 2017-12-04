package model;

/**
 * Created by mateusz on 04.12.2017.
 */
public class Edge {
    private String to;
    private String from;
    private int weight;

    public Edge(String to, String from, int weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", weight=" + weight +
                '}';
    }
}
