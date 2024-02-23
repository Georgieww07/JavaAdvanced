package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deque<Integer> portionsFoodStack = new ArrayDeque<>();
        List<Integer> food = Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int f : food) {
            portionsFoodStack.push(f);
        }

        Deque<Integer> staminaQueue = new ArrayDeque<>();
        List<Integer> stamina = Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int s : stamina) {
            staminaQueue.offer(s);
        }

        Deque<Integer> peaksStack = new ArrayDeque<>();
        peaksStack.push(70);
        peaksStack.push(60);
        peaksStack.push(100);
        peaksStack.push(90);
        peaksStack.push(80);

        List<String> peaks = new ArrayList<>();
        int climbedPeaks = 0;

        for (int i = 1; i <= 7; i++) {
            int currFood = portionsFoodStack.peek();
            int currStamina = staminaQueue.peek();

            int sum = currFood + currStamina;

            if (sum >= peaksStack.peek()){
                portionsFoodStack.pop();
                staminaQueue.poll();
                peaksStack.pop();

                climbedPeaks++;
            }else {
                portionsFoodStack.pop();
                staminaQueue.poll();
            }

            if (climbedPeaks == 5){
                break;
            }

        }

        if (climbedPeaks == 5){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            System.out.println("Conquered peaks:");
            System.out.println("Vihren");
            System.out.println("Kutelo");
            System.out.println("Banski Suhodol");
            System.out.println("Polezhan");
            System.out.println("Kamenitza");
        }else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
            if (climbedPeaks == 1){
                System.out.println("Conquered peaks:");
                System.out.println("Vihren");
            }else if (climbedPeaks == 2){
                System.out.println("Conquered peaks:");
                System.out.println("Vihren");
                System.out.println("Kutelo");
            }else if (climbedPeaks == 3){
                System.out.println("Conquered peaks:");
                System.out.println("Vihren");
                System.out.println("Kutelo");
                System.out.println("Banski Suhodol");
            }else if (climbedPeaks == 4){
                System.out.println("Conquered peaks:");
                System.out.println("Vihren");
                System.out.println("Kutelo");
                System.out.println("Banski Suhodol");
                System.out.println("Polezhan");
            }
        }

    }
}
