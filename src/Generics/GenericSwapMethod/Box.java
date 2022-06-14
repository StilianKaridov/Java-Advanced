package Generics.GenericSwapMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private List<T> value;

    public Box() {
        this.value = new ArrayList<>();
    }

    public void add(T element) {
        value.add(element);
    }

    public void swap(int firstElement, int secondElement) {
        Collections.swap(value, firstElement, secondElement);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : value) {
            sb.append(t.getClass().getName()).append(": ")
                    .append(t.toString())
                    .append("\n");
        }

        return sb.toString().trim();
    }
}
