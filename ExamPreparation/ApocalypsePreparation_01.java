package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] textileInput = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] medInput = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> textileQueue = new ArrayDeque<>();
        for (int textile : textileInput) {
            textileQueue.offer(textile);
        }

        Deque<Integer> medStack = new ArrayDeque<>();
        for (int med : medInput) {
            medStack.push(med);
        }


        Map<String, Integer> medicaments = new HashMap<>();

        while (!textileQueue.isEmpty() && !medStack.isEmpty()) {
            int currentTextile = textileQueue.peek();
            int currentMed = medStack.peek();

            if (currentTextile + currentMed == 30) {
                textileQueue.poll();
                medStack.pop();
                if (!medicaments.containsKey("Patch")) {
                    medicaments.put("Patch", 1);
                } else {
                    medicaments.put("Patch", medicaments.get("Patch") + 1);
                }

            } else if (currentTextile + currentMed == 40) {
                textileQueue.poll();
                medStack.pop();
                if (!medicaments.containsKey("Bandage")) {
                    medicaments.put("Bandage", 1);
                } else {
                    medicaments.put("Bandage", medicaments.get("Bandage") + 1);
                }

            } else if (currentTextile + currentMed == 100) {
                textileQueue.poll();
                medStack.pop();
                if (!medicaments.containsKey("MedKit")) {
                    medicaments.put("MedKit", 1);
                } else {
                    medicaments.put("MedKit", medicaments.get("MedKit") + 1);
                }
            } else if (currentTextile + currentMed > 100) {
                if (!medicaments.containsKey("MedKit")) {
                    medicaments.put("MedKit", 1);
                } else {
                    medicaments.put("MedKit", medicaments.get("MedKit") + 1);
                }
                textileQueue.poll();
                medStack.pop();

                int toAdd = (currentTextile + currentMed - 100);
                int increasedVal = medStack.pop() + toAdd;
                medStack.push(increasedVal);
            } else {
                textileQueue.poll();
                int curr = medStack.pop() + 10;
                medStack.push(curr);
            }
        }


        if (medStack.isEmpty() && textileQueue.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (medStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles are empty.");
        }

            if (!medicaments.isEmpty()) {
                medicaments = medicaments.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

                for (Map.Entry<String, Integer> entry : medicaments.entrySet()) {
                    System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                }
            }

            if (!medStack.isEmpty()) {
                System.out.println("Medicaments left: " + String.join(", ", medStack.toString()).replace("[", "").replace("]", ""));
            }

            if (!textileQueue.isEmpty()) {
                System.out.println("Textiles left: " + String.join(", ", textileQueue.toString()).replace("[", "").replace("]", ""));
            }
        }
    }
