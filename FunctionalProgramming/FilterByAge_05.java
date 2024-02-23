package FunctionalProgramming;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterByAge_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> personAge = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] inputParts = scanner.nextLine().split(",\\s+");
            String name = inputParts[0];
            int age = Integer.parseInt(inputParts[1]);

            personAge.putIfAbsent(name, age);

        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();


        print(personAge, condition, age, format);

    }

    public static void print(Map<String, Integer> personAge, String condition, int age, String format){
        if ("younger".equals(condition)){
            for (Map.Entry<String, Integer> entry : personAge.entrySet()) {
                if ("name".equals(format)){
                    if (entry.getValue() <= age){
                        System.out.println(entry.getKey());
                    }
                }else if ("age".equals(format)){
                    if (entry.getValue() <= age){
                        System.out.println(entry.getValue());
                    }
                }else if ("name age".equals(format)){
                    if (entry.getValue() <= age){
                        System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                    }
                }


            }


        }else if ("older".equals(condition)){
            for (Map.Entry<String, Integer> entry : personAge.entrySet()) {
                if ("name".equals(format)){
                    if (entry.getValue() >= age){
                        System.out.println(entry.getKey());
                    }
                }else if ("age".equals(format)){
                    if (entry.getValue() >= age){
                        System.out.println(entry.getValue());
                    }
                }else if ("name age".equals(format)){
                    if (entry.getValue() >= age){
                        System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                    }
                }


            }

        }
    }
}