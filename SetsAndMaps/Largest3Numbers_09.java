package SetsAndMaps;

import com.sun.jdi.IntegerType;
import com.sun.jdi.IntegerValue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());


        if (numbers.size() < 3){
            for (int n : numbers) {
                System.out.print(n + " ");
            }
        }else {
            for (int i = 0; i < 3; i++) {
                System.out.print(numbers.get(i) + " ");

            }
        }



    }
}
