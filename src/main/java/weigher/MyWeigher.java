package weigher;

import com.github.steveash.maxclique.Weigher;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * @author Steve Ash
 */
public class MyWeigher implements Weigher<String> {

    private final Table<String, String, Double> w = HashBasedTable.create();

    public MyWeigher clear() {
        w.clear();
        return this;
    }

    public MyWeigher put(String a, String b, double weight) {
        if (a.compareTo(b) > 0) {
            String t = a;
            a = b;
            b = t;
        }

        w.put(a, b, weight);
        return this;
    }

    public double weigh(String a, String b) {
        if (a.compareTo(b) > 0) {
            String t = a;
            a = b;
            b = t;
        }

        Double maybe = w.get(a, b);
        if (maybe == null) return -1;

        return maybe;
    }
}

