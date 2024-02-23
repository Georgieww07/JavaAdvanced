package DefiningClassesExercise.OpinionPoll_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> data = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputParts = scanner.nextLine().split("\\s+");
            String name = inputParts[0];
            int age = Integer.parseInt(inputParts[1]);

            Person person = new Person(name, age);
            data.add(person);

        }

        data.stream().filter(person -> person.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);

    }
}
