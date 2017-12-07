import com.github.steveash.maxclique.Clique;
import com.github.steveash.maxclique.Cliques;
import model.Edge;
import parser.GraphParser;
import weigher.MyWeigher;
import weigher.WeigherFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mateusz on 04.12.2017.
 */
public class Main {
    public static void main(String[] args ) {
        GraphParser parser = new GraphParser("src/main/resources/input-2.xml");

        WeigherFactory factory = new WeigherFactory(parser.getEdges());
        MyWeigher weigher = factory.createWeigher();

        Clique<String> maximumClique = Cliques.findMaximum(parser.getNodes(), weigher);
        System.out.println(maximumClique.members());
    }
}
