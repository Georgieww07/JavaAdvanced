package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());

        List<Integer> evenNumbers = numbers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(String.join(", ", evenNumbers.toString()).replace("[", "").replace("]", ""));

        Collections.sort(evenNumbers);
        System.out.println(String.join(", ", evenNumbers.toString()).replace("[", "").replace("]", ""));





    }
}
