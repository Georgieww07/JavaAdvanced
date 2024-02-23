package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // TODO 1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '('){
                stack.push(i);
            }else if (current == ')'){
                String expr = input.substring(stack.pop(), i + 1);
                System.out.println(expr);
            }

        }


    }
}
