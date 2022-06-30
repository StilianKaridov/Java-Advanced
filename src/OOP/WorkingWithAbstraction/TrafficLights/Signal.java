package OOP.WorkingWithAbstraction.TrafficLights;

public enum Signal {
    RED("GREEN"),
    YELLOW("RED"),
    GREEN("YELLOW");

    private String next;

    Signal(String next) {
        this.next = next;
    }

    public String getNext() {
        return next;
    }
}
