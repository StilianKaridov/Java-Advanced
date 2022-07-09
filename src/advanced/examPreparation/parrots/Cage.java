package advanced.examPreparation.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            data.add(parrot);
        }

    }

    public boolean remove(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        Parrot toReturn = null;
        for (Parrot current : this.data) {
            if (current.getName().equals(name)) {
                toReturn = current;
                current.setAvailable(false);
                break;
            }
        }
        return toReturn;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> toReturn = new ArrayList<>();

        for (Parrot current : this.data) {
            if (current.getSpecies().equals(species)) {
                sellParrot(current.getName());
                toReturn.add(current);
            }
        }
        return toReturn;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:%n", this.name));

        for (Parrot current : this.data) {
            if (current.isAvailable()) {
                sb.append(String.format("%s%n", current.toString()));
            }
        }

        return sb.toString().trim();
    }
}
