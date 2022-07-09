package advanced.iteratorsAndComparators.listyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private List<String> collection;
    private int index = 0;

    public ListyIterator() {
        this.collection = new ArrayList<>();
    }

    public boolean hasNext() {
        return this.index + 1 < collection.size();
    }

    public boolean move() {
        if (this.index + 1 < collection.size()) {
            this.index++;
            return true;
        }

        return false;
    }

    public void print() {
        if (collection.isEmpty()) {
            throw new NullPointerException("Invalid Operation!");
        }

        System.out.println(collection.get(index));
    }

    public void create(String... strings) {
        this.collection = List.of(strings);
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<String> spliterator() {
        return Iterable.super.spliterator();
    }

    public void printAll() {
        collection.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
