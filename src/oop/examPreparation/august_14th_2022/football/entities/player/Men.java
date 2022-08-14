package oop.examPreparation.august_14th_2022.football.entities.player;

public class Men extends BasePlayer {

    public Men(String name, String nationality, int strength) {
        super(name, nationality, strength);
        super.setKg(85.50);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + 145);
    }
}
