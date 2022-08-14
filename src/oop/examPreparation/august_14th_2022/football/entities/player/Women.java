package oop.examPreparation.august_14th_2022.football.entities.player;

public class Women extends BasePlayer {

    public Women(String name, String nationality, int strength) {
        super(name, nationality, strength);
        super.setKg(60.00);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + 115);
    }
}
