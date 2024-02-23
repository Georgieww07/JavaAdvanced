package ExamPreparation;

import java.util.*;

public class RubberDuckDebuggers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> timeQueue = new ArrayDeque<>();
        Deque<Integer> tasksStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(e -> timeQueue.offer(e));

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(e -> tasksStack.push(e));

        Map<String, Integer> duckInfo = new LinkedHashMap<>();
        duckInfo.put("Darth Vader Ducky", 0);
        duckInfo.put("Thor Ducky", 0);
        duckInfo.put("Big Blue Rubber Ducky", 0);
        duckInfo.put("Small Yellow Rubber Ducky", 0);

        while (!timeQueue.isEmpty() && !tasksStack.isEmpty()){
            int currTime = timeQueue.poll();
            int currTask = tasksStack.pop();
            int result = currTime * currTask;

            if (result >= 0 && result <= 60){
                duckInfo.put("Darth Vader Ducky", duckInfo.get("Darth Vader Ducky") + 1);
            }else if (result <= 120){
                duckInfo.put("Thor Ducky", duckInfo.get("Thor Ducky") + 1);
            }else if (result <= 180){
                duckInfo.put("Big Blue Rubber Ducky", duckInfo.get("Big Blue Rubber Ducky") + 1);
            }else if (result <= 240){
                duckInfo.put("Small Yellow Rubber Ducky", duckInfo.get("Small Yellow Rubber Ducky") + 1);
            }else {
                currTask -= 2;
                tasksStack.push(currTask);
                timeQueue.offer(currTime);

            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        duckInfo.entrySet().forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}
