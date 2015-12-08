package kata5.model;

@FunctionalInterface
public interface Attribute<T, R> {
    R get(T item);
}
