package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(Integer::parseInt)
                .forEach(stack::push);
        System.out.println();

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println();
    }
}
