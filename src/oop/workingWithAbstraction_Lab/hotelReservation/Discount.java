package oop.workingWithAbstraction_Lab.hotelReservation;

public enum Discount {
    VIP(0.8),
    SECOND_VISIT(0.9),
    NONE(1);

    private double multiplier;

    Discount(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public static Discount parse(String str) {
        switch (str) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown enum value" + str);
        }
    }
}
