package SetsAndMapsExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, String> phoneBook = new HashMap<>();


        while (true) {
            String input = scanner.nextLine();
            if ("search".equals(input)){
                break;
            }

            String[] inputParts = input.split("-");
            String name = inputParts[0];
            String number = inputParts[1];

            if (!phoneBook.containsKey(name)){
                phoneBook.put(name, number);
            }else {
                phoneBook.put(name, number);
            }
        }

        while (true) {
            String user = scanner.nextLine();
            if ("stop".equals(user)){
                break;
            }

            if (phoneBook.containsKey(user)){
                System.out.printf("%s -> %s\n", user, phoneBook.get(user));
            }else {
                System.out.printf("Contact %s does not exist.\n", user);
            }
        }

    }
}
