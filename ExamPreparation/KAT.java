package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> platesQueue = new ArrayDeque<>();
        Deque<Integer> carsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                        .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> platesQueue.offer(e));

        Arrays.stream(scanner.nextLine()
                        .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> carsStack.push(e));


        int days = 0;
        int count = 0;
        while (!platesQueue.isEmpty() && !carsStack.isEmpty()){
            int currPlates = platesQueue.poll();
            int currCars = carsStack.pop();

            days++;


            if (currPlates > currCars * 2){
                int leftPlates = currPlates - currCars * 2;
                platesQueue.offer(leftPlates);

                count += currCars;
            }else if (currPlates < currCars * 2){
                int leftCars = currCars - (currPlates / 2);
                carsStack.offer(leftCars);

                count += currPlates / 2;
            }else {
                count += currCars;
            }
        }

        System.out.printf("%s cars were registered for %d days!%n", count, days);

        if (platesQueue.isEmpty() && carsStack.isEmpty()){
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
        if (!platesQueue.isEmpty()){
            int sum = 0;
            while (!platesQueue.isEmpty()){
                sum += platesQueue.poll();
            }
            System.out.printf("%d license plates remain!%n", sum);
        }

        if (!carsStack.isEmpty()){
            int sum = 0;
            while (!carsStack.isEmpty()){
                sum += carsStack.pop();
            }
            System.out.printf("%d cars remain without license plates!%n", sum);
        }


    }
}
