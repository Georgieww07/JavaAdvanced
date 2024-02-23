package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Predicate<String> isUppercase = s -> Character.isUpperCase(s.charAt(0));
        Consumer<String> print = e -> System.out.println(e);

        List<String> uppercaseWords = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .filter(isUppercase)
                .collect(Collectors.toList());

        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(print);
    }
}
