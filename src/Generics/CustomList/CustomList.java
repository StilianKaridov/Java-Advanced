package Generics.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public T remove(int index) {
        return values.remove(index);
    }

    public boolean contains(T element) {
        if (values.contains(element)) {
            return true;
        }

        return false;
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(values, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        return (int) values.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return values.stream().max(Comparator.naturalOrder()).get();
    }

    public T getMin() {
        return values.stream().min(Comparator.naturalOrder()).get();
    }

    public int getSize(){
        return values.size();
    }

    public T getIndex(int index){
        return values.get(index);
    }

    public void print() {
        for (T value : values) {
            System.out.println(value);
        }
    }
}
