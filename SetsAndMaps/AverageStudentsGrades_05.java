package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputParts = scanner.nextLine().split("\\s+");
            String student = inputParts[0];
            double grade = Double.parseDouble(inputParts[1]);

            studentGrades.putIfAbsent(student, new ArrayList<>());
            studentGrades.get(student).add(grade);

        }

        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            List<Double> v = entry.getValue();
            String result = v.stream().map(g -> String.format("%.2f", g)).collect(Collectors.joining(" "));
            double average = findAverage(v);

            System.out.printf("%s -> %s (avg: %.2f)%n", entry.getKey(), result, average);
        }
    }

    private static double findAverage(List<Double> v) {
        double sum = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v.get(i);
        }
        return sum / v.size();
    }
}
