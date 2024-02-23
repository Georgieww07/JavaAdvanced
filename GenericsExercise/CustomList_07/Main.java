package GenericsExercise.CustomList_07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        CustomList<String> customList = new CustomList<>();
        while (true) {
            String input = scanner.nextLine();
            if ("END".equals(input)) {
                break;
            }
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];

            switch (command) {
                case "Add":
                    String elementAdd = commandParts[1];
                    customList.add(elementAdd);
                    break;
                case "Remove":
                    int indexRemove = Integer.parseInt(commandParts[1]);
                    customList.remove(indexRemove);
                    break;
                case "Contains":
                    String elementContains = commandParts[1];
                    System.out.println(customList.contains(elementContains));
                    break;
                case "Swap":
                    int idx1 = Integer.parseInt(commandParts[1]);
                    int idx2 = Integer.parseInt(commandParts[2]);

                    customList.swap(idx1, idx2);
                    break;
                case "Greater":
                    String elementGreater = commandParts[1];
                    System.out.println(customList.countGreaterThan(elementGreater));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }

        }


    }
}

