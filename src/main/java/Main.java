import com.github.steveash.maxclique.Clique;
import com.github.steveash.maxclique.Cliques;
import parser.GraphParser;
import weigher.MyWeigher;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mateusz on 04.12.2017.
 */
public class Main {
    public static void main(String[] args ) {
        GraphParser parser = new GraphParser("src/main/resources/input-2.xml");
        parser.getGraph();
        

        List<String> nodesInMyGraph = Arrays.asList("0", "1", "2", "3", "4", "5");

        // need to make an insteance of Weigher<T> which knows how to produce a "weight" (double)
        // given two nodes (T's) from the graph; any weights <= 0 are treated as negative infinity
        MyWeigher w = new MyWeigher();
        w.put("0", "1", 10.0);
        w.put("1", "2", 10.0);
        w.put("0", "2", 10.0);

        // find the maximum clique in the graph
        Clique<String> maximumClique = Cliques.findMaximum(nodesInMyGraph, w);

        // the members of the clique will be in the set: maximumClique.members()
        System.out.println(maximumClique.members());
    }
}
