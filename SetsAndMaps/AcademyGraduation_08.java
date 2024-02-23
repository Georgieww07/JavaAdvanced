package SetsAndMaps;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> studentInfo = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double sum = 0;
            for (int j = 0; j < grades.length; j++) {
                sum += grades[j];
            }

            double studentAverage = sum / grades.length;

            studentInfo.putIfAbsent(name, studentAverage);


        }


        for (Map.Entry<String, Double> entry : studentInfo.entrySet()) {
            String name = entry.getKey();
            DecimalFormat format = new DecimalFormat("0.###############");
            String value = String.format(entry.getValue().toString(), format);
            System.out.printf("%s is graduated with %s%n", name, value);

        }
    }
}
