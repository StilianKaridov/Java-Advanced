package oop.examPreparation.august_14th_2022.football.entities.player;

import static oop.examPreparation.august_14th_2022.football.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player {

    private String name;
    private String nationality;
    private double kg;
    private int strength;

    public BasePlayer(String name, String nationality, int strength) {
        setName(name);
        setNationality(nationality);
        setStrength(strength);
    }

    protected void setKg(double kg) {
        this.kg = kg;
    }

    private void setNationality(String nationality) {
        if (nationality == null || nationality.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }

        this.nationality = nationality;
    }

    protected void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }

        this.strength = strength;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public double getKg() {
        return this.kg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }
}
