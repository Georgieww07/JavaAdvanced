package SetsAndMaps;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> cars = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)){
            String[] tokens = input.split(",\\s+");
            String direction = tokens[0];
            String carNumber = tokens[1];

            if ("IN".equals(direction)){
                cars.add(carNumber);
            }else if ("OUT".equals(direction)){
                cars.remove(carNumber);
            }

            input = scanner.nextLine();

        }

        if (cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String car : cars) {
                System.out.println(car);

            }
        }

    }
}
