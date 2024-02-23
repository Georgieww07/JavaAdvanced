package ExamPreparation;

import java.util.*;

public class ChocolateTime_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQueue = new ArrayDeque<>();
        Deque<Double> cacaoStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Double::parseDouble)
                .forEach(e -> milkQueue.offer(e));

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Double::parseDouble)
                .forEach(e -> cacaoStack.push(e));

        Map<String, Integer> chocInfo = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()){
            double milk = milkQueue.poll();
            double cacao = cacaoStack.pop();

            double percentage = (cacao / (cacao + milk)) * 100;

            if (percentage == 30){
                chocInfo.putIfAbsent("Milk Chocolate", 0);
                chocInfo.put("Milk Chocolate", chocInfo.get("Milk Chocolate") + 1);

            }else if (percentage == 50){
                chocInfo.putIfAbsent("Dark Chocolate", 0);
                chocInfo.put("Dark Chocolate", chocInfo.get("Dark Chocolate") + 1);

            }else if (percentage == 100){
                chocInfo.putIfAbsent("Baking Chocolate", 0);
                chocInfo.put("Baking Chocolate", chocInfo.get("Baking Chocolate") + 1);

            }else {
                milk += 10;
                milkQueue.offer(milk);
            }

        }

        if (chocInfo.size() == 3){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entry : chocInfo.entrySet()) {
            System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());

        }
    }
}
