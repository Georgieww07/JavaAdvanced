package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");

        if (isBalanced(input)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    private static boolean isBalanced(String[] input) {

        Deque<String> stack = new ArrayDeque<>();
        for (String brace : input) {
            switch (brace) {
                case "}":
                    if (stack.isEmpty()) {
                        return false;
                    }
                    String openBrace = stack.pop();
                    if (!"{".equals(openBrace)) {
                        return false;
                    }
                    break;
                case "]":
                    if (stack.isEmpty()) {
                        return false;
                    }
                    openBrace = stack.pop();
                    if (!"[".equals(openBrace)) {
                        return false;
                    }
                    break;
                case ")":
                    if (stack.isEmpty()) {
                        return false;
                    }
                    openBrace = stack.pop();
                    if (!"(".equals(openBrace)) {
                        return false;
                    }
                    break;
                default:
                    stack.push(brace);
                    break;
            }
        }
            return stack.isEmpty();
    }
}
