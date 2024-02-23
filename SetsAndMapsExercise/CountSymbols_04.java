package SetsAndMapsExercise;
import java.util.*;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<Character, Integer> occurrences = new TreeMap<>();

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentLetter = input.charAt(i);

            if (!occurrences.containsKey(currentLetter)){
                occurrences.put(currentLetter, 1);
            }else {
                occurrences.put(currentLetter, occurrences.get(currentLetter) + 1);
            }
        }

        //S: 1 time/s
        //U: 1 time/s

        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());

        }

    }
}
