package IteratorsAndComparators.ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterator<String> {
    private List<String> collection;
    private int index = 0;

    public ListyIterator() {
        this.collection = new ArrayList<>();
    }

    @Override
    public boolean hasNext() {
        return this.index + 1 < collection.size();
    }

    @Override
    public String next() {
        return collection.get(index++);
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
}
