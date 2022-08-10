package oop.examPreparation.august_22nd.unitTesting.test.java.farmville;

import oop.examPreparation.august_22nd.unitTesting.main.java.farmville.Animal;
import oop.examPreparation.august_22nd.unitTesting.main.java.farmville.Farm;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmvilleTests {

    @Test
    public void test_CreateFarm_Successfully() {
        Farm farm = new Farm("hayday", 5);
        assertEquals("hayday", farm.getName());
        assertEquals(5, farm.getCapacity());
        assertEquals(0, farm.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateFarm_WithNullName_ShouldThrow() {
        Farm farm = new Farm(null, 4);
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateFarm_WithEmptyName_ShouldThrow() {
        Farm farm = new Farm("    ", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateFarm_WithCapacityBelowZero_ShouldThrow() {
        Farm farm = new Farm("hayday", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_NoFreeSpaceToAdd_ShouldThrow() {
        Farm farm = new Farm("hayday", 2);
        farm.add(new Animal("Lion", 100));
        farm.add(new Animal("Cat", 50));
        farm.add(new Animal("Dog", 75));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_AnimalExists_ShouldThrow() {
        Farm farm = new Farm("hayday", 2);
        farm.add(new Animal("Lion", 100));
        farm.add(new Animal("Lion", 50));
    }

    @Test
    public void test_Add_Successfully() {
        Farm farm = new Farm("hayday", 2);
        farm.add(new Animal("Lion", 100));

        assertEquals(1, farm.getCount());
    }

    @Test
    public void test_Remove_AnimalInNotInTheFarm_ShouldReturnFalse() {
        Farm farm = new Farm("hayday", 2);
        farm.add(new Animal("Lion", 100));

        assertFalse(farm.remove("Dog"));
        assertEquals(1, farm.getCount());
    }

    @Test
    public void test_Remove_Successfully_ShouldReturnTrue() {
        Farm farm = new Farm("hayday", 2);
        farm.add(new Animal("Lion", 100));

        assertTrue(farm.remove("Lion"));
        assertEquals(0, farm.getCount());
    }
}
