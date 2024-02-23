package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class OsPlanning_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> taskStack = new ArrayDeque<>();
        Deque<Integer> threadQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> taskStack.push(e));

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> threadQueue.offer(e));

        int killTask = Integer.parseInt(scanner.nextLine());


        while (!threadQueue.isEmpty() && !taskStack.isEmpty()){
            int currTask = taskStack.pop();

            if (currTask == killTask){
                break;
            }

            int currThread = threadQueue.poll();
            if (currThread < currTask){
                taskStack.push(currTask);
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", threadQueue.peek(), killTask);

        while (!threadQueue.isEmpty()){
            System.out.print(threadQueue.poll() + " ");
        }
    }
}
