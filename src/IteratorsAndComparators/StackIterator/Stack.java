package IteratorsAndComparators.StackIterator;

import java.util.*;
import java.util.function.Consumer;

public class Stack implements Iterable<Integer>{
    private ArrayDeque<Integer> stack;

    public Stack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(Integer... toPush) {
        for (Integer current : toPush) {
            this.stack.push(current);
        }
    }

    public Integer pop() {
        if (this.stack.isEmpty()) {
            throw new NoSuchElementException("No elements");
        }
        return this.stack.pop();
    }

    public void print() {
        this.stack.forEach(System.out::println);
    }

    @Override
    public Iterator<Integer> iterator() {
        return stack.iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Iterable.super.spliterator();
    }
}
