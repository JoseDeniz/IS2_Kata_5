package kata5.process;

import kata5.model.Attribute;
import kata5.model.Histogram;

import java.util.List;

public class HistogramBuilder<T> {

    private final List<T> items;

    public HistogramBuilder(List<T> items) {
        this.items = items;
    }

    public <A> Histogram<A> build(Attribute<T, A> attribute) {
        Histogram<A> histogram = new Histogram<>();
        items.forEach(item -> histogram.increment(attribute.get(item)));
        return histogram;
    }

}
