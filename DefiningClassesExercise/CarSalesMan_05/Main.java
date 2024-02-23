package DefiningClassesExercise.CarSalesMan_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String engineModel = tokens[0];
            int enginePower = Integer.parseInt(tokens[1]);

            int displacement;
            String efficiency;

            Engine engine = null;
            if (tokens.length == 4) {
                displacement = Integer.parseInt(tokens[2]);
                efficiency = tokens[3];

                engine = new Engine(engineModel, enginePower, displacement, efficiency);

            } else if (tokens.length == 3) {
                if (tokens[2].matches("\\d+")) {
                    displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(engineModel, enginePower, displacement);
                } else {
                    efficiency = tokens[2];
                    engine = new Engine(engineModel, enginePower, efficiency);
                }
            } else if (tokens.length == 2) {
                engine = new Engine(engineModel, enginePower);

            }
            engines.add(engine);

        }

        List<Car> cars = new ArrayList<>();

        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String carModel = carInfo[0];
            String carEngine = carInfo[1];

            Engine currEngine = null;
            for (Engine engine : engines) {
                if (engine.getEngineModel().equals(carEngine)) {
                    currEngine = engine;
                }

            }


            int weight;
            String colour;

            Car car = null;
            if (carInfo.length == 4) {
                weight = Integer.parseInt(carInfo[2]);
                colour = carInfo[3];
                car = new Car(carModel, currEngine, weight, colour);
            } else if (carInfo.length == 3) {
                if (carInfo[2].matches("\\d+")) {
                    weight = Integer.parseInt(carInfo[2]);
                    car = new Car(carModel, currEngine, weight);
                } else {
                    colour = carInfo[2];
                    car = new Car(carModel, currEngine, colour);
                }
            } else if (carInfo.length == 2) {
                car = new Car(carModel, currEngine);

            }
            cars.add(car);

        }

        //          FordFocus:
        //        //V4-33:
        //        //Power: 140
        //        //Displacement: 28
        //        //Efficiency: B
        //        //Weight: 1300
        //        //Color: Silver

        for (Car car : cars) {
            System.out.println(car);
            if (car.getEngine().getEngineDisplacement() == 0) {
                System.out.printf("Displacement: n/a%n");
            }else {
                System.out.printf("Displacement: %d%n", car.getEngine().getEngineDisplacement());
            }

            if (car.getEngine().getEngineEfficiency() == null) {
                System.out.printf("Efficiency: n/a%n");
            }else {
                System.out.printf("Efficiency: %s%n", car.getEngine().getEngineEfficiency());
            }

            if (car.getWeight() == 0) {
                System.out.printf("Weight: n/a%n");
            }else {
                System.out.printf("Weight: %d%n", car.getWeight());
            }

            if (car.getColour() == null) {
                System.out.printf("Color: n/a%n");
            }else {
                System.out.printf("Color: %s%n", car.getColour());
            }





        }
    }
}
