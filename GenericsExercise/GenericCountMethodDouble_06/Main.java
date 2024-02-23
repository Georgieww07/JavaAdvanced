package GenericsExercise.GenericCountMethodDouble_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Double>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Double input = Double.parseDouble(scanner.nextLine());
            Box<Double> box = new Box<>(input);
            boxList.add(box);
        }

        Double element = Double.parseDouble(scanner.nextLine());
        Box<Double> stringBox = new Box<>(element);
        System.out.println(count(boxList, stringBox));

    }

    public static <T extends Comparable<T>> int count(List<T> list, T element) {
        int count = 0;
        for (T el : list) {
            if (el.compareTo(element) > 0){
                count++;
            }
        }

        return count;
    }
}
