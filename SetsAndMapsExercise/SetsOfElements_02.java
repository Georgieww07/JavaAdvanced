package SetsAndMapsExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizes = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstSetSize = sizes[0];
        int secondSetSize = sizes[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            firstSet.add(currentNum);
        }

        for (int i = 0; i < secondSetSize; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            secondSet.add(currentNum);
        }

        Set<Integer> result = new LinkedHashSet<>();

        for (int number1 : firstSet) {
            for (int number2 : secondSet) {

                if (number1 == number2){
                    result.add(number1);
                }

            }
        }


        for (int resultNum : result) {
            System.out.print(resultNum +" ");

        }
    }

}
