package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EnergyDrinks_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> caffeineStack = new ArrayDeque<>();
        Deque<Integer> drinksQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> caffeineStack.push(e));

        Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> drinksQueue.offer(e));


        int totalCaffeine = 0;
        while (!caffeineStack.isEmpty() && !drinksQueue.isEmpty()){
            int currCaffeine = caffeineStack.pop();
            int currDrink = drinksQueue.poll();
            int sum = currCaffeine * currDrink;

            totalCaffeine += sum;

            if (totalCaffeine > 300){
                totalCaffeine -= sum;
                drinksQueue.offer(currDrink);
                if (totalCaffeine != 0){
                    totalCaffeine -= 30;
                }

            }
        }

        if (!drinksQueue.isEmpty()){
            System.out.printf("Drinks left: %s%n", String.join(", ", drinksQueue.toString()).replace("[", "").replace("]", ""));
        }else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCaffeine);

    }
}
