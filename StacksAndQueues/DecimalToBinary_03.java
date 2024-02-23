package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (decimal / 2 != 0){
            int current = decimal % 2;
            stack.push(current);
            decimal /= 2 ;
        }
        stack.push(decimal);


        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
