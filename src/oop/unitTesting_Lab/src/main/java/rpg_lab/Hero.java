package rpg_lab;

public class Hero {

    private String name;
    private int experience;
    private Axe weapon;

    public Hero(String name, Axe axe) {
        this.name = name;
        this.experience = 0;
        this.weapon = axe;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Axe getWeapon() {
        return this.weapon;
    }

    public void attack(Dummy target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }
}
