package advanced.definingClasses.carSalesman;


public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color = "n/a";

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        if (this.weight == 0) {
            return String.format("%s:\n" +
                            "%s\n" +
                            "Weight: n/a\n" +
                            "Color: %s", this.model
                    , this.engine.toString()
                    , this.color);
        } else {
            return String.format("%s:\n" +
                            "%s\n" +
                            "Weight: %d\n" +
                            "Color: %s", this.model
                    , this.engine.toString()
                    , this.weight
                    , this.color);
        }

    }
}
