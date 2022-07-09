package advanced.examPreparation.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return this.data.removeIf(e -> e.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        Egg egg = this.data.get(0);
        for (Egg datum : this.data) {
            if (datum.getStrength() > egg.getStrength()) {
                egg = datum;
            }
        }
        return egg;
    }

    public Egg getEgg(String color) {
        return this.data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:%n", this.material));
        for (Egg egg : this.data) {
            sb.append(String.format("%s%n", egg.toString()));
        }
        return sb.toString().trim();
    }

}