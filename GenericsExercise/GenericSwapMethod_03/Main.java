package GenericsExercise.GenericSwapMethod_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Integer>> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(input);
            data.add(box);
        }

        int[] idx = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstIdx = idx[0];
        int secondIdx = idx[1];

        swap(data, firstIdx, secondIdx);
        data.forEach(e -> System.out.println(e));

    }

    public static <T> void swap(List<T> list, int firstIdx, int secondIdx){
        T element1 = list.get(firstIdx);
        T element2 = list.get(secondIdx);

        list.set(firstIdx, element2);
        list.set(secondIdx, element1);

    }
}
