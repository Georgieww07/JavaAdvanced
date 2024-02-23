package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddVAT_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Function<Double, Double> addVat = x -> x * 1.2;
        Function<String, Double> parseToDouble = s -> Double.parseDouble(s);
        Consumer<Double> printResult = r -> System.out.printf("%.2f%n", r);

        List<Double> result = Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(e -> parseToDouble.apply(e))
                .map(e -> addVat.apply(e))
                .collect(Collectors.toList());


        System.out.println("Prices with VAT: ");
        result.forEach(a -> printResult.accept(a));

    }
}
