package oop.examPreparation.december_11th.unitTesting.test.java.cats;

import oop.examPreparation.december_11th.unitTesting.main.java.cats.Cat;
import oop.examPreparation.december_11th.unitTesting.main.java.cats.House;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HouseTests {

    private static final String HOUSE_NAME = "Targaryen";
    private static final int HOUSE_CAPACITY = 3;

    private House house;
    private List<Cat> cats;

    @Before
    public void setUp() {
        this.house = new House(HOUSE_NAME, HOUSE_CAPACITY);
        this.cats = addCatsToList();
    }

    private List<Cat> addCatsToList() {
        List<Cat> toAdd = new ArrayList<>();

        for (int i = 0; i < HOUSE_CAPACITY; i++) {
            toAdd.add(new Cat("Cat_" + i));
        }

        return toAdd;
    }

    @Test
    public void test_CreateHouse_Successfully() {
        assertEquals(HOUSE_NAME, house.getName());
        assertEquals(HOUSE_CAPACITY, house.getCapacity());
        assertEquals(0, house.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateHouse_WithNullName_ShouldThrow() {
        House nullNameHouse = new House(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateHouse_WithWhiteSpaceName_ShouldThrow() {
        House whiteSpacesNameHouse = new House("   ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateHouse_WithCapacityBelowZero_ShouldThrow() {
        House invalidCapacityHouse = new House("houseName", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddCat_HouseIsFull_ShouldThrow() {
        for (Cat cat : cats) {
            house.addCat(cat);
        }

        Cat cat1 = new Cat("Tommy");
        house.addCat(cat1);
    }

    @Test
    public void test_AddCat_Successfully() {
        for (Cat cat : cats) {
            house.addCat(cat);
        }

        assertEquals(cats.size(), house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveCat_WithNullElement_ShouldThrow() {
        for (Cat cat : cats) {
            house.addCat(cat);
        }

        house.removeCat("InvalidCatName");
    }

    @Test
    public void test_RemoveCat_Successfully() {
        for (Cat cat : cats) {
            house.addCat(cat);
        }

        int expectedCatsCount = house.getCount() - 1;

        house.removeCat("Cat_2");
        assertEquals(expectedCatsCount, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CatForSale_WithNullElement_ShouldThrow() {
        for (Cat cat : cats) {
            house.addCat(cat);
        }

        house.catForSale("InvalidCatName");
    }

    @Test
    public void test_CatForSale_Successfully() {
        String catName = "Cat_2";

        for (Cat cat : cats) {
            house.addCat(cat);
        }

        Cat cat = house.catForSale(catName);
        assertFalse(cat.isHungry());
    }

    @Test
    public void test_Statistics_Successfully() {
        String expected = "The cat Cat_0, Cat_1, Cat_2 is in the house " + HOUSE_NAME + "!";

        for (Cat cat : cats) {
            house.addCat(cat);
        }

        String actual = house.statistics();

        assertEquals(expected, actual);
    }
}
