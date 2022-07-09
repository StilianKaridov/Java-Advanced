package oop.workingWithAbstraction_Lab.hotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int value;

    Season(int season) {
        this.value = season;
    }

    public static Season parse(String str) {
        return Season.valueOf(str.toUpperCase());
    }

    public int getValue() {
        return value;
    }
}
