package Advanced.IteratorsAndComparators.StrategyPattern;

import java.util.Comparator;

public class LengthNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().length() == o2.getName().length()) {
            char firstName = o1.getName().toLowerCase().charAt(0);
            char secondName = o2.getName().toLowerCase().charAt(0);
            return Character.compare(firstName, secondName);
        }
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
