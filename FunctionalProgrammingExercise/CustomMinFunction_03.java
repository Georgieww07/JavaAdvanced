package FunctionalProgrammingExercise;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Integer[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);



        Function<Integer[], Integer> returnMin = arr -> {
            int min = Integer.MAX_VALUE;
            for (int currentNum : arr) {
                if (currentNum < min) {
                    min = currentNum;
                }
            }
            return min;
        };

        System.out.println(returnMin.apply(numbers));

    }
}
