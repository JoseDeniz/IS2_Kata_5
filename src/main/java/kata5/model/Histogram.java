package kata5.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Histogram<T> {

    private final Map<T, Integer> histogram;

    public Histogram() {
        histogram = new HashMap<>();
    }

    public void increment(T key) {
        histogram.put(key, histogram.containsKey(key) ? histogram.get(key) + 1 : 1);
    }

    public Integer get(T key) {
        return histogram.get(key);
    }

    public Set<T> keySet() {
        return histogram.keySet();
    }

    @Override
    public String toString() {
        return "Histogram" + histogram;
    }
}
