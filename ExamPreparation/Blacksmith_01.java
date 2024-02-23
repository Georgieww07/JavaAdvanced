package ExamPreparation;

import com.sun.source.tree.Tree;

import java.util.*;

public class Blacksmith_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deque<Integer> steelQueue = new ArrayDeque<>();
        Deque<Integer> carbonStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(steelQueue::offer);

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbonStack::push);


        Map<String, Integer> swords = new TreeMap<>();
        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()){
            int currSteel = steelQueue.poll();
            int currCarbon = carbonStack.pop();
            int sum = currSteel + currCarbon;

            if (sum == 70){
                swords.putIfAbsent("Gladius", 0);
                swords.put("Gladius", swords.get("Gladius") + 1);

            }else if (sum == 80){
                swords.putIfAbsent("Shamshir", 0);
                swords.put("Shamshir", swords.get("Shamshir") + 1);

            }else if (sum == 90){
                swords.putIfAbsent("Katana", 0);
                swords.put("Katana", swords.get("Katana") + 1);

            }else if (sum ==110){
                swords.putIfAbsent("Sabre", 0);
                swords.put("Sabre", swords.get("Sabre") + 1);

            }else {
                currCarbon += 5;
                carbonStack.push(currCarbon);
            }
        }

        if (!swords.isEmpty()){
            System.out.printf("You have forged %d swords.%n", swords.values().stream().mapToInt(e -> e).sum());
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()){
            System.out.println("Steel left: none");
        }else {
            System.out.printf("Steel left: %s", String.join(", ", steelQueue.toString()).replace("[", "").replace("]", ""));
            System.out.println();
        }

        if (carbonStack.isEmpty()){
            System.out.println("Carbon left: none");
        }else {
            System.out.printf("Carbon left: %s", String.join(", ", carbonStack.toString()).replace("[", "").replace("]", ""));
            System.out.println();
        }

        if (!swords.isEmpty()){
            swords.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
        }
    }
}
