package DefiningClassesExercise.RawData_04;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());


        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);

            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Map<Double, Integer> tireInfo = new LinkedHashMap<>();
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            tireInfo.put(tire1Pressure, tire1Age);

            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            tireInfo.put(tire2Pressure, tire2Age);

            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            tireInfo.put(tire3Pressure, tire3Age);

            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);
            tireInfo.put(tire4Pressure, tire4Age);

            Tire tire = new Tire(tireInfo);

            Car car = new Car(model, engine, cargo, tire);
            cars.add(car);

        }


        String command = scanner.nextLine();
        if ("fragile".equals(command)){
            cars = cars.stream().filter(car -> car.getCargo().getCargoType().equals("fragile")).collect(Collectors.toList());
            cars = cars.stream().filter(car -> car.getTire().checkTires()).collect(Collectors.toList());
            cars.stream().forEach(car -> System.out.println(car.getModel()));

        }else if ("flamable".equals(command)){
            cars = cars.stream().filter(car -> car.getCargo().getCargoType().equals("flamable")).collect(Collectors.toList());
            cars = cars.stream().filter(car -> car.getEngine().getEnginePower() > 250).collect(Collectors.toList());
            cars.stream().forEach(car -> System.out.println(car.getModel()));

        }
        
    }
}
