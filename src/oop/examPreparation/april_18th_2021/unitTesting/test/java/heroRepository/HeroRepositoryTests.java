package oop.examPreparation.april_18th_2021.unitTesting.test.java.heroRepository;

import oop.examPreparation.april_18th_2021.unitTesting.main.java.heroRepository.Hero;
import oop.examPreparation.april_18th_2021.unitTesting.main.java.heroRepository.HeroRepository;
import org.junit.Before;
import org.junit.Test;


import java.util.Collection;

import static org.junit.Assert.*;

public class HeroRepositoryTests {

    private HeroRepository heroRepository;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
    }

    @Test
    public void test_CreateEmptyRepository() {
        HeroRepository repo = new HeroRepository();

        int expectedSize = 0;
        int actualSize = repo.getCount();

        assertEquals(expectedSize, actualSize);
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateHero_WithNullArgument_ShouldThrow() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateHero_WithExistingHero_ShouldThrow() {
        Hero hero = new Hero("Dumbledore", 20);
        Hero hero2 = new Hero("Dumbledore", 15);

        heroRepository.create(hero);
        heroRepository.create(hero2);
    }

    @Test
    public void test_CreateHero_Successfully() {
        String expectedReturn = "Successfully added hero Dumbledore with level 20";
        String actualReturn = heroRepository.create(new Hero("Dumbledore", 20));

        int expectedSize = 1;
        int actualSize = heroRepository.getCount();

        assertEquals(expectedReturn, actualReturn);
        assertEquals(expectedSize, actualSize);
    }

    @Test(expected = NullPointerException.class)
    public void test_RemoveHero_WithNullName_ShouldThrow() {
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void test_RemoveHero_WithWhiteSpaceName_ShouldThrow() {
        heroRepository.remove("     ");
    }

    @Test
    public void test_RemoveHero_WithNonExistingName_ShouldReturn_False() {
        heroRepository.create(new Hero("Dumbledore", 15));
        heroRepository.create(new Hero("Harry Potter", 20));

        assertFalse(heroRepository.remove("Voldemort"));
    }

    @Test
    public void test_RemoveHero_Successfully_ShouldReturn_True() {
        heroRepository.create(new Hero("Dumbledore", 15));
        heroRepository.create(new Hero("Harry Potter", 20));

        assertTrue(heroRepository.remove("Dumbledore"));
    }

    @Test
    public void test_GetHeroWith_HighestLevel_ShouldReturnNull() {
        assertNull(heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void test_GetHeroWith_HighestLevel_Successfully() {
        heroRepository.create(new Hero("Dumbledore", 15));
        heroRepository.create(new Hero("Harry Potter", 20));

        String expectedName = "Harry Potter";
        int expectedLevel = 20;

        Hero heroWithHighestLevel = heroRepository.getHeroWithHighestLevel();

        assertEquals(expectedName, heroWithHighestLevel.getName());
        assertEquals(expectedLevel, heroWithHighestLevel.getLevel());
    }

    @Test
    public void test_GetHero_ByName_ShouldReturnNull() {
        heroRepository.create(new Hero("Dumbledore", 15));
        heroRepository.create(new Hero("Harry Potter", 20));

        assertNull(heroRepository.getHero("Voldemort"));
    }

    @Test
    public void test_GetHero_ByName_Successfully() {
        heroRepository.create(new Hero("Dumbledore", 15));
        heroRepository.create(new Hero("Harry Potter", 20));

        String expectedName = "Dumbledore";
        int expectedLevel = 15;

        Hero hero = heroRepository.getHero("Dumbledore");

        assertEquals(expectedName, hero.getName());
        assertEquals(expectedLevel, hero.getLevel());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_GetHeroes_AsUnmodifiableCollection_Successfully() {
        heroRepository.create(new Hero("Dumbledore", 15));
        heroRepository.create(new Hero("Harry Potter", 20));

        Collection<Hero> heroes = heroRepository.getHeroes();

        heroes.add(new Hero("Voldemort", 100));
    }
}
