package ExamPreparation;

import java.util.*;

public class WormsAndHoles_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deque<Integer> wormsStack = new ArrayDeque<>();
        Deque<Integer> holesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> wormsStack.push(e));

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> holesQueue.offer(e));

        int matches = 0;
        int sumWorms = wormsStack.size();
        while (!wormsStack.isEmpty() && !holesQueue.isEmpty()){
            int worm = wormsStack.pop();
            int hole = holesQueue.poll();

            if (worm != hole){
                worm -= 3;
                if (worm > 0){
                    wormsStack.push(worm);
                }
            }else {
                matches++;
            }


        }

        if (matches > 0){
            System.out.printf("Matches: %d%n", matches);
        }else {
            System.out.println("There are no matches.");
        }

        if (wormsStack.isEmpty() && matches < sumWorms){
            System.out.println("Worms left: none");
        }else if (wormsStack.isEmpty() && matches == sumWorms){
            System.out.println("Every worm found a suitable hole!");
        }else {
            //System.out.printf("Worms left: %s%n", String.join(", ", wormsStack.toString()).replace("[", "").replace("]", ""));
            while (!wormsStack.isEmpty()){
                List<Integer> list = new ArrayList<>();
                while(!wormsStack.isEmpty()){
                    int curr = wormsStack.pop();
                    list.add(curr);
                }
                Collections.reverse(list);
                System.out.printf("Worms left: %s%n", String.join(", ", list.toString()).replace("[", "").replace("]", ""));

            }
        }

        if (holesQueue.isEmpty()){
            System.out.println("Holes left: none");
        }else {
            System.out.printf("Holes left: %s", String.join(", ", holesQueue.toString()).replace("[", "").replace("]", ""));
        }

    }
}
