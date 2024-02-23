package RegularExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ChickenSnack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //money Stack
        //price Queue

        Deque<Integer> moneyStack = new ArrayDeque<>();
        Deque<Integer> priceQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> moneyStack.push(e));

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> priceQueue.offer(e));


        int countFood = 0;
        while (!moneyStack.isEmpty() && !priceQueue.isEmpty()){
            int money = moneyStack.peek();
            int price = priceQueue.peek();

            if (money == price){
                moneyStack.pop();
                priceQueue.poll();
                countFood++;

            }else if (money > price){
                int change = money - price;

                moneyStack.pop();

                if (!moneyStack.isEmpty()){
                    int nextMoney = moneyStack.pop();
                    nextMoney += change;
                    moneyStack.push(nextMoney);
                }
                priceQueue.poll();

                countFood++;

            }else if (money < price){
                moneyStack.pop();
                priceQueue.poll();

            }
        }

        if (countFood >= 4){
            System.out.printf("Gluttony of the day! Henry ate %d foods.%n", countFood);
        }else if (countFood == 1){
            System.out.printf("Henry ate: %d food.%n", countFood);
        } else if (countFood > 0){
            System.out.printf("Henry ate: %d foods.%n", countFood);
        }else if (countFood == 0){
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }
    }
}
