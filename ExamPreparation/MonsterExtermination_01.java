package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MonsterExtermination_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> armorQueue = new ArrayDeque<>();
        Deque<Integer> strikeStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split(","))
                .map(Integer::parseInt)
                .forEach(e -> armorQueue.offer(e));

        Arrays.stream(scanner.nextLine()
                .split(","))
                .map(Integer::parseInt)
                .forEach(e -> strikeStack.push(e));


        int countKills = 0;
        while (!armorQueue.isEmpty() && !strikeStack.isEmpty()){
            int currArmor = armorQueue.poll();
            int currStrike = strikeStack.pop();

            if (currStrike >= currArmor){
                countKills++;
                currStrike -= currArmor;

                if (currStrike > 0 && strikeStack.size() >= 1){
                    int nextStrike = strikeStack.pop();
                    nextStrike += currStrike;
                    strikeStack.push(nextStrike);
                }else {
                    if (currStrike > 0){
                        strikeStack.push(currStrike);
                    }
                }
            }else {
                currArmor -= currStrike;
                armorQueue.offer(currArmor);
            }
        }

        if (armorQueue.isEmpty()){
            System.out.println("All monsters have been killed!");
        }
        if (strikeStack.isEmpty()){
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", countKills);
    }
}
