package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int ALIVE_HEALTH = 100;
    private static final int EXPERIENCE = 200;
    private static final int DEAD_HEALTH = 0;
    private static final int ATTACK = 1;
    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        this.aliveDummy = new Dummy(ALIVE_HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(DEAD_HEALTH, EXPERIENCE);
    }

    @Test
    public void test_AliveDummy_LoseHealth_WhenAttacked() {
        aliveDummy.takeAttack(ATTACK);
        assertEquals(aliveDummy.getHealth(), ALIVE_HEALTH - ATTACK);
    }

    @Test(expected = IllegalStateException.class)
    public void test_DeadDummy_ThrowsException_WhenAttacked() {
        deadDummy.takeAttack(ATTACK);
    }

    @Test
    public void test_DeadDummy_CanGiveExperience() {
        int actual = deadDummy.giveExperience();
        assertEquals(EXPERIENCE, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void test_AliveDummy_CantGiveExperience() {
        aliveDummy.giveExperience();
    }
}