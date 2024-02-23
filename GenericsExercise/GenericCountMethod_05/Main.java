package GenericsExercise.GenericCountMethod_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<String> box = new Box<>(input);
            boxList.add(box);
        }

        String element = scanner.nextLine();
        Box<String> stringBox = new Box<>(element);
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
