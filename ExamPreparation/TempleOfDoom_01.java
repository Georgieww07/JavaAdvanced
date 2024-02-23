package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> toolsQueue = new ArrayDeque<>();
        Deque<Integer> substancesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> toolsQueue.offer(e));

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> substancesStack.push(e));

        List<Integer> challenges = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty()){
            int currTool = toolsQueue.poll();
            int currSubstance = substancesStack.pop();
            int result = currTool * currSubstance;

            if (challenges.contains(result)){
                int idx = challenges.indexOf(result);
                challenges.remove(idx);
            }else {
                currTool++;
                toolsQueue.offer(currTool);

                currSubstance--;
                if (currSubstance != 0){
                    substancesStack.push(currSubstance);
                }
            }
        }

        if (!challenges.isEmpty()){
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        //Tools: element1, element2, element3 … elementn"
        //o	"Substances: element1, element2, element3 … elementn"
        //o	"Challenges: element1, element2, element3 … elementn"
        if (!toolsQueue.isEmpty()){
            System.out.println("Tools: " + String.join(", ", toolsQueue.toString()).replace("[", "").replace("]", ""));
        }
        if (!substancesStack.isEmpty()){
            System.out.println("Substances: " + String.join(", ", substancesStack.toString()).replace("[", "").replace("]", ""));
        }
        if (!challenges.isEmpty()){
            System.out.println("Challenges: " + String.join(", ", challenges.toString()).replace("[", "").replace("]", ""));
        }

    }
}
