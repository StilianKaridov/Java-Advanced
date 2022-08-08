package oop.examPreparation.december_20th.unitTesting.test.java.garage;


import oop.examPreparation.december_20th.unitTesting.main.java.garage.Car;
import oop.examPreparation.december_20th.unitTesting.main.java.garage.Garage;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.*;

public class GarageTests {

    private Garage garage;

    @Before
    public void setUp() {
        this.garage = new Garage();
    }

    @Test
    public void test_Constructor_ShouldCreate_EmptyList() {
        int expectedCount = 0;
        int actualCount = garage.getCount();

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void test_GetCars_Return_ThreeElements() {
        garage.addCar(new Car("1", 1, 1));
        garage.addCar(new Car("2", 2, 2));
        garage.addCar(new Car("3", 3, 3));

        int expectedCount = 3;
        List<Car> cars = garage.getCars();
        int actualCount = cars.size();

        assertEquals(expectedCount, actualCount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddCar_WithNullElement_ShouldThrow() {
        garage.addCar(null);
    }

    @Test
    public void test_FindAllCars_WithMaxSpeedAbove_Return_2_Cars() {
        garage.addCar(new Car("1", 30, 1));
        garage.addCar(new Car("2", 40, 2));
        garage.addCar(new Car("3", 50, 3));

        List<Car> cars = garage.findAllCarsWithMaxSpeedAbove(35);
        int expectedCount = 2;
        int actualCount = cars.size();

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void test_GetTheMostExpensiveCar_ReturnsNull() {
        Car car = garage.getTheMostExpensiveCar();

        assertNull(car);
    }

    @Test
    public void test_GetTheMostExpensiveCar_Successfully() {
        garage.addCar(new Car("1", 30, 200));
        garage.addCar(new Car("2", 40, 250));
        garage.addCar(new Car("3", 50, 50));

        Car car = garage.getTheMostExpensiveCar();

        assertEquals(250, car.getPrice(), 0);
    }

    @Test
    public void test_FindAllCars_ByBrand_Successfully() {
        garage.addCar(new Car("Chevrolet", 30, 200));
        garage.addCar(new Car("Mercedes", 50, 300));
        garage.addCar(new Car("Mercedes", 40, 250));
        garage.addCar(new Car("Audi", 50, 50));

        String brand = "Mercedes";

        List<Car> cars = garage.findAllCarsByBrand(brand);
        int expectedCount = 2;
        int actualCount = cars.size();

        assertEquals(expectedCount, actualCount);

        for (Car car : cars) {
            assertEquals(brand, car.getBrand());
        }
    }
}