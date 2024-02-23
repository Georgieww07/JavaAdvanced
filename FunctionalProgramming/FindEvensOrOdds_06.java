package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class FindEvensOrOdds_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int[] bounds = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();


        List<Integer> result = new ArrayList<>();
        for (int i = bounds[0]; i <= bounds[1]; i++) {
            if ("even".equals(command)){
                if (i % 2 == 0){
                    result.add(i);
                }
            }else if ("odd".equals(command)){
                if (i % 2 != 0){
                    result.add(i);
                }
            }

        }

        for (int n : result) {
            System.out.print(n + " ");

        }


    }
}
