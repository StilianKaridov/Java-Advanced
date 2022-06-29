package Advanced.DefiningClasses.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        while (numberOfCars-- > 0) {
            List<Tire> tires = new ArrayList<>();
            String[] data = scanner.nextLine().split(" ");

            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];

            for (int i = 5; i < data.length; i += 2) {
                double pressure = Double.parseDouble(data[i]);
                int age = Integer.parseInt(data[i + 1]);
                tires.add(new Tire(pressure, age));
            }
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = scanner.nextLine();
        switch (command) {
            case "fragile":
                cars.stream().filter(car -> car.getCargo().getType().equals("fragile"))
                        .filter(car -> car.getTires().stream().anyMatch(e->e.getPressure() < 1)).forEach(System.out::println);
                break;
            case "flamable":
                cars.stream().filter(car -> car.getCargo().getType().equals("flamable"))
                        .filter(car -> car.getEngine().getPower() > 250).forEach(System.out::println);
                break;
        }
    }
}