package Advanced.IteratorsAndComparators.Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    List<Integer> lake;

    public Lake(Integer... lake) {
        setLake(lake);
    }

    public void setLake(Integer... lake) {
        this.lake = List.of(lake);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }


    class Frog implements Iterator<Integer> {
        int index = 0;
        boolean firstRoundFinished = false;

        @Override
        public boolean hasNext() {
            return index < lake.size();
        }

        @Override
        public Integer next() {
            int currentIndex = index;
            index += 2;
            if (index >= lake.size() && !firstRoundFinished) {
                index = 1;
                firstRoundFinished = true;
            }
            return lake.get(currentIndex);
        }
    }

}
