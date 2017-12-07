package weigher;

import model.Edge;

import java.util.List;

/**
 * Created by mateusz on 07.12.2017.
 */
public class WeigherFactory {
    private final List<Edge> edges;

    public WeigherFactory(List<Edge> edges) {
        this.edges = edges;
    }

    public MyWeigher createWeigher() {
        MyWeigher weigher = new MyWeigher();
        edges.stream().forEach(edge -> weigher.put(edge.getFrom(), edge.getTo(), edge.getWeight()));
        return weigher;
    }
}
