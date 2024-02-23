package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] nsx = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = nsx[0];
        int s = nsx[1];
        int x = nsx[2];


        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }


        if (stack.isEmpty()){
            System.out.println(0);
        }else if (stack.contains(x)){
            System.out.println(true);
        }else {
            isSmallest(stack);
        }

    }

    private static void isSmallest(Deque<Integer> stack) {
        int min = Integer.MAX_VALUE;
        for (int el : stack) {
            if (el < min){
                min = el;
            }
        }
        System.out.println(min);
    }
}
