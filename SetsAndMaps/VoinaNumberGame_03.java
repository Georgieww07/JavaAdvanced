package SetsAndMaps;

import java.util.*;

public class VoinaNumberGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbersFirstPlayer = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbersSecondPlayer = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        Set<Integer> firstPlayerDeck = new LinkedHashSet<>();
        Set<Integer> secondPlayerDeck = new LinkedHashSet<>();

        Arrays.stream(numbersFirstPlayer).forEach(firstPlayerDeck::add);
        Arrays.stream(numbersSecondPlayer).forEach(secondPlayerDeck::add);

        int round = 1;
        while (round <= 50 && !firstPlayerDeck.isEmpty() && !secondPlayerDeck.isEmpty()){

            int firstNumber = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstNumber);

            int secondNumber = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondNumber);

            if (firstNumber > secondNumber){
                firstPlayerDeck.add(firstNumber);
                firstPlayerDeck.add(secondNumber);
            }else if (secondNumber > firstNumber){
                secondPlayerDeck.add(firstNumber);
                secondPlayerDeck.add(secondNumber);
            }

            round++;
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()){
            System.out.println("First player win!");
        }else if (firstPlayerDeck.size() < secondPlayerDeck.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }

    }
}
