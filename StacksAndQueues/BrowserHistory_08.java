package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> stack2 = new ArrayDeque<>();

        while (true){
            String input = scanner.nextLine();
            if ("Home".equals(input)){
                break;
            }

            if (!"back".equals(input) && !"forward".equals(input)){
                stack.push(input);
                System.out.println(stack.peek());
                stack2.clear();
            }else if ("back".equals(input)) {
                if (stack.size() > 1){
                    stack2.push(stack.pop());
                    System.out.println(stack.peek());
                }else {
                    System.out.println("no previous URLs");
                }

            }else {
                if (stack2.size() >= 1){
                    System.out.println(stack2.peek());
                    stack.push(stack2.pop());
                }else {
                    System.out.println("no next URLs");
                }
            }


        }
    }
}
