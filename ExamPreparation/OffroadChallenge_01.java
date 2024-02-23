package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class OffroadChallenge_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deque<Integer> initialFuelStack = new ArrayDeque<>();
        Deque<Integer> indexQueue = new ArrayDeque<>();
        Deque<Integer> neededFuelQueue = new ArrayDeque<>();

        int[] inputFuel = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] inputIndex = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] inputNeededFuel = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();



        for (int fuel : inputFuel) {
            initialFuelStack.push(fuel);
        }

        for (int index : inputIndex) {
            indexQueue.offer(index);
        }

        for (int neededF : inputNeededFuel) {
            neededFuelQueue.offer(neededF);
        }


        List<String> altitudes = new ArrayList<>();

        int count = 0;
        while (!initialFuelStack.isEmpty()){
            int fuel = initialFuelStack.peek();
            int index = indexQueue.peek();
            int neededFuel = neededFuelQueue.peek();

            count++;
            if (fuel - index >= neededFuel){
                String altitude = "Altitude " + count;
                System.out.println("John has reached: " + altitude);

                altitudes.add(altitude);

                initialFuelStack.pop();
                indexQueue.poll();
                neededFuelQueue.poll();
            }else {
                String altitude = "Altitude " + count;
                System.out.println("John did not reach: " + altitude);
                break;
            }
        }

        if (!initialFuelStack.isEmpty() && !altitudes.isEmpty()){
            System.out.println("John failed to reach the top.");
            System.out.printf("Reached altitudes: %s", String.join(", ", altitudes));
            System.out.println();
        }else if (altitudes.isEmpty()){
            System.out.println("John failed to reach the top.");
            System.out.println("John didn't reach any altitude.");
        }else {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }

    }
}
