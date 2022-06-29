package Advanced.DefiningClasses.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new LinkedHashMap<>();
        while (numberOfEngines-- > 0) {

            String[] engineData = scanner.nextLine().split(" ");
            Engine engine = null;
            String engineModel = engineData[0];
            int power = Integer.parseInt(engineData[1]);

            switch (engineData.length) {
                case 2:
                    engine = new Engine(engineModel, power);
                    break;
                case 3:
                    int displacement;
                    String efficiency;
                    if (engineData[2].matches("\\d+")) {
                        displacement = Integer.parseInt(engineData[2]);
                        engine = new Engine(engineModel, power, displacement);
                    } else {
                        efficiency = engineData[2];
                        engine = new Engine(engineModel, power, efficiency);
                    }

                    break;
                case 4:
                    displacement = Integer.parseInt(engineData[2]);
                    efficiency = engineData[3];
                    engine = new Engine(engineModel, power, displacement, efficiency);
                    break;
            }
            engines.putIfAbsent(engineModel, engine);
        }

        List<Car> cars = new ArrayList<>();
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        while (numberOfCars-- > 0) {

            String[] carData = scanner.nextLine().split(" ");

            String carModel = carData[0];
            String engineModel = carData[1];
            Engine engine = engines.get(engineModel);
            Car car = null;

            switch (carData.length) {
                case 2:
                    car = new Car(carModel, engine);
                    break;
                case 3:
                    if (carData[2].matches("\\d+")) {
                        int weight = Integer.parseInt(carData[2]);
                        car = new Car(carModel, engine, weight);
                    } else {
                        String color = carData[2];
                        car = new Car(carModel, engine, color);
                    }
                    break;
                case 4:
                    int weight = Integer.parseInt(carData[2]);
                    String color = carData[3];
                    car = new Car(carModel, engine, weight, color);
                    break;
            }
            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}