package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> stack = new ArrayDeque<>();

        while (true){
            String input = scanner.nextLine();
            if ("Home".equals(input)){
                break;
            }

            if (!"back".equals(input)){
                stack.push(input);
                System.out.println(stack.peek());
            }else {
                if (stack.size() < 2){
                    System.out.println("no previous URLs");
                }else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }






        }
    }
}
