package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        // Predicate<List<String>> remove = list -> list.stream().filter(s -> s.startsWith())


        while (true) {
            String input = scanner.nextLine();
            if ("Party!".equals(input)) {
                break;
            }
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];
            String criteria = commandParts[1];


            switch (criteria) {
                case "StartsWith":
                    String parameter = commandParts[2];
                    if ("Remove".equals(command)) {
                        people = people.stream()
                                .filter(s -> !s.startsWith(parameter))
                                .collect(Collectors.toList());

                    } else if ("Double".equals(command)) {
                        List<String> toAdd = people.stream()
                                .filter(s -> s.startsWith(parameter))
                                .collect(Collectors.toList());
                        people.addAll(toAdd);
                    }
                    break;
                case "EndsWith":
                    String parameter2 = commandParts[2];
                    if ("Remove".equals(command)) {
                        people = people.stream()
                                .filter(s -> !s.endsWith(parameter2))
                                .collect(Collectors.toList());

                    } else if ("Double".equals(command)) {
                        List<String> toAdd = people.stream()
                                .filter(s -> s.endsWith(parameter2))
                                .collect(Collectors.toList());
                        people.addAll(toAdd);
                    }
                    break;
                case "Length":
                    int length = Integer.parseInt(commandParts[2]);
                    if ("Remove".equals(command)){
                        people = people.stream()
                                .filter(s -> s.length() != length)
                                .collect(Collectors.toList());

                    }else if ("Double".equals(command)){
                        List<String> toAdd = people.stream()
                                .filter(s -> s.length() == length)
                                .collect(Collectors.toList());
                        people.addAll(toAdd);
                    }
                    break;

            }

        }

        if (people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            Collections.sort(people);
            //System.out.printf("%s are going to the party!", String.join(", ", people)
                    //.replace("[", "")
                   // .replace("]", ""));

            System.out.println(people.stream().collect(Collectors.joining(", ")) + " are going to the party!");
        }
    }
}
