package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> parser = s -> Integer.parseInt(s);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(parser)
                .collect(Collectors.toList());

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }


        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sum);
    }
}
