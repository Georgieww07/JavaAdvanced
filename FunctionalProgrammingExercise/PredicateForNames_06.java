package FunctionalProgrammingExercise;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int length = Integer.parseInt(scanner.nextLine());

        Predicate<String> isSmaller = s -> s.length() <= length;

        Arrays.stream(scanner.nextLine().split("\\s+")).filter(isSmaller).forEach(name -> System.out.println(name));
    }
}
