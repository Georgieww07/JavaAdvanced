package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (true){
            String fileName = scanner.nextLine();
            if ("print".equals(fileName)){
                break;
            }

            if (!"cancel".equals(fileName)){
                queue.offer(fileName);
            }else {
                if (queue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled " + queue.poll());
                }
            }
        }

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
