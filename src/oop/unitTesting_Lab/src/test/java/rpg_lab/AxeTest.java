package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int ATTACK = 5;
    private static final int DURABILITY = 10;
    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 200;
    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void test_AxeDurability_Decrement_AfterAttack() {
        axe.attack(dummy);
        assertEquals(DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void test_WillAttack_IfBroken() {
        int durability = 0;

        Axe axe = new Axe(ATTACK, durability);

        assertEquals(0, axe.getDurabilityPoints());

        axe.attack(dummy);
    }
}