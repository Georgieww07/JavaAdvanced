package FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> add = list -> list.stream()
                .map(a -> a + 1)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> multiply = list -> list.stream()
                .map(a -> a * 2)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> subtract = list -> list.stream()
                .map(a -> a - 1)
                .collect(Collectors.toList());

        Consumer<List<Integer>> print = list -> list.stream().forEach(e -> System.out.print(e + " "));


        while (true) {
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            switch (input) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
        }



    }
}
