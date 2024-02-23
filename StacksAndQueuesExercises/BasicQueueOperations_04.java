package StacksAndQueuesExercises;

import java.util.*;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queue= new ArrayDeque<>();
        int[] nsx = Arrays.stream(scanner.nextLine().
                split(" ")).
                mapToInt(Integer::parseInt)
                .toArray();


        int n = nsx[0];
        int s = nsx[1];
        int x = nsx[2];


        Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);


        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.isEmpty()){
            System.out.println(0);
        }else if (queue.contains(x)){
            System.out.println(true);
        }else {
            System.out.println(Collections.min(queue));
        }

    }
}
