package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //TODO 2 + 5 + 10 - 2 - 1


        ArrayDeque<String> stack = new ArrayDeque<>();

        String expression = scanner.nextLine();
        String[] parts = expression.split(" ");


        for (int i = parts.length - 1; i >= 0; i--){
            stack.push(parts[i]);
        }

        while (stack.size() > 1){
            Integer firstNum = Integer.parseInt(stack.pop());
            String op = stack.pop();
            Integer secondNum = Integer.parseInt(stack.pop());


            switch (op){
                case "+":
                    stack.push(String.valueOf(firstNum + secondNum));
                    break;
                case "-":
                    stack.push(String.valueOf(firstNum - secondNum));
                    break;
            }
        }

        System.out.println(stack.peek());




    }
}
