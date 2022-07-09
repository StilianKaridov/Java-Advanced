package advanced.generics.customList;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        for (int i = 0; i < list.getSize(); i++) {
            for (int j = i + 1; j < list.getSize(); j++) {
                if (list.getIndex(i).compareTo(list.getIndex(j)) > 0) {
                    list.swap(i, j);
                }
            }
        }
    }
}
