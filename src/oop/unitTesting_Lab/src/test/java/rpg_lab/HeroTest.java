package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void test_HeroExperience_GainedWhen_TargetDies() {
        Axe axe = Mockito.mock(Axe.class);
        Dummy dummy = Mockito.mock(Dummy.class);

        Hero hero = new Hero("Javarcho", axe);
        assertEquals(0, hero.getExperience());

        Mockito.when(dummy.isDead()).thenReturn(true);
        Mockito.when(dummy.giveExperience()).thenReturn(200);

        hero.attack(dummy);
        assertEquals(200, hero.getExperience());
    }
}