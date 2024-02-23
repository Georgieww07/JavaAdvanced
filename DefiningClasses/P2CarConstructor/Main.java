package DefiningClasses.P2CarConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");

            if (carInfo.length == 1){
                String brand = carInfo[0];
                Car car = new Car(brand);

                cars.add(car);
            }else if (carInfo.length == 3){
                String brand = carInfo[0];
                String model = carInfo[1];
                int horsePower = Integer.parseInt(carInfo[2]);

                Car car = new Car(brand, model, horsePower);
                cars.add(car);
            }
        }


        cars.forEach(c -> System.out.println(c));
    }
}
