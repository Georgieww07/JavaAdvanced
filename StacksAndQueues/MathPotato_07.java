package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] children = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> queue = new PriorityQueue<>();

        for (String child : children) {
            queue.offer(child);
        }

        int cycle = 1;
        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (!isPrime(cycle)) {
                System.out.println("Removed " + queue.poll());
            }else {
                System.out.println("Prime " + queue.peek());
            }

            cycle++;
        }

        System.out.println("Last is " + queue.poll());

    }
    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
