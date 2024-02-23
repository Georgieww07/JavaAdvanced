package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> people = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());


        System.out.println(people.stream().collect(Collectors.joining(", ")));
    }
}
