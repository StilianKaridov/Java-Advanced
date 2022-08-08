package oop.examPreparation.april_18th.unitTesting.test.java.petStore;

import oop.examPreparation.april_18th.unitTesting.main.java.petStore.Animal;
import oop.examPreparation.april_18th.unitTesting.main.java.petStore.PetStore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PetStoreTests {

    @Test
    public void test_Constructor_ShouldCreateEmpty_ArrayList() {
        PetStore empty = new PetStore();

        assertEquals(new ArrayList<>(), empty.getAnimals());
    }

    @Test
    public void test_GetCount_WithThree_Elements() {
        int expected = 3;

        PetStore petStore = new PetStore();
        petStore.addAnimal(new Animal("1", 10, 10));
        petStore.addAnimal(new Animal("2", 20, 20));
        petStore.addAnimal(new Animal("3", 30, 30));

        int actual = petStore.getCount();

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddAnimal_WithNullElement_ShouldThrow() {
        Animal animal = null;

        PetStore petStore = new PetStore();
        petStore.addAnimal(animal);
    }

    @Test
    public void test_AddAnimal_Successfully() {
        Animal animal = new Animal("1", 10, 10);

        PetStore petStore = new PetStore();
        petStore.addAnimal(animal);

        int expectedCount = 1;
        int actualCount = petStore.getCount();

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void test_FindAllAnimals_WithMaxKg_ShouldReturn_EmptyList() {
        PetStore petStore = new PetStore();
        petStore.addAnimal(new Animal("1", 10, 10));
        petStore.addAnimal(new Animal("2", 20, 20));
        petStore.addAnimal(new Animal("3", 30, 30));

        List<Animal> actual = petStore.findAllAnimalsWithMaxKilograms(40);

        assertEquals(new ArrayList<>(), actual);
    }

    @Test
    public void test_FindAllAnimals_WithMaxKg_ShouldReturn_OneAnimal() {
        PetStore petStore = new PetStore();
        petStore.addAnimal(new Animal("1", 10, 10));
        petStore.addAnimal(new Animal("2", 20, 20));
        petStore.addAnimal(new Animal("3", 30, 30));

        int expectedCount = 1;

        List<Animal> actual = petStore.findAllAnimalsWithMaxKilograms(25);
        int actualCount = actual.size();

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void test_GetTheMostExpensiveAnimal_Returns_Null(){
        PetStore petStore = new PetStore();
        Animal animal = petStore.getTheMostExpensiveAnimal();

        assertNull(animal);
    }

    @Test
    public void test_GetTheMostExpensiveAnimal_Returns_TheMostExpensiveAnimal(){
        PetStore petStore = new PetStore();
        petStore.addAnimal(new Animal("1", 10, 10));
        petStore.addAnimal(new Animal("2", 20, 20));
        petStore.addAnimal(new Animal("3", 30, 30));

        double expectedPrice = 30;

        Animal mostExpensive = petStore.getTheMostExpensiveAnimal();
        double actualPrice = mostExpensive.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void test_FindAllAnimalBySpecie_ShouldReturn_EmptyList(){
        PetStore petStore = new PetStore();
        petStore.addAnimal(new Animal("1", 10, 10));
        petStore.addAnimal(new Animal("2", 20, 20));
        petStore.addAnimal(new Animal("3", 30, 30));

        List<Animal> emptyList = petStore.findAllAnimalBySpecie("4");

        assertEquals(new ArrayList<>(), emptyList);
    }

    @Test
    public void test_FindAllAnimalBySpecie_Successfully(){
        PetStore petStore = new PetStore();
        petStore.addAnimal(new Animal("1", 10, 10));
        petStore.addAnimal(new Animal("2", 20, 20));
        petStore.addAnimal(new Animal("3", 30, 30));

        String expectedSpecie = "3";
        List<Animal> emptyList = petStore.findAllAnimalBySpecie("3");
        String actualSpecie = emptyList.get(0).getSpecie();

        assertEquals(expectedSpecie, actualSpecie);
    }
}

