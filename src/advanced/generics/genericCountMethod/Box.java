package advanced.generics.genericCountMethod;

import java.util.List;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public static <T extends Comparable<T>> long genericCount(List<T> list, T type){
        return list.stream().filter(e->e.compareTo(type) > 0).count();
    }

}
