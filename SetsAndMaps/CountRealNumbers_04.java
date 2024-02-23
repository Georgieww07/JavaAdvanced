package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();


        Map<Double, Integer> result = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            double currentNum = numbers[i];

            if (!result.containsKey(currentNum)){
                result.put(currentNum, 1);
            }else {
                result.put(currentNum, result.get(currentNum) + 1);
            }

        }

        for (Map.Entry<Double, Integer> kvp : result.entrySet()) {
            System.out.printf("%.1f -> %d%n", kvp.getKey(), kvp.getValue());
        }
    }
}
