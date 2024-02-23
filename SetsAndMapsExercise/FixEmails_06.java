package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> personEmail = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if ("stop".equals(input)){
                break;
            }

            String email = scanner.nextLine();
            String emailCheck  = email.toLowerCase();

            if (emailCheck.charAt(emailCheck.length() - 1) != 'm' && emailCheck.charAt(emailCheck.length() - 1) != 'k' && emailCheck.charAt(emailCheck.length() - 1) != 's'){
                personEmail.putIfAbsent(input, email);
            }
        }


        //John -> johnDoe@softuni.org

        for (Map.Entry<String, String> entry : personEmail.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());

        }
    }
}
