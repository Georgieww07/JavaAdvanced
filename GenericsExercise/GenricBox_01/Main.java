package GenericsExercise.GenricBox_01;

import GenericsExercise.GenricBox_01.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<String> box = new Box<>(input);
            System.out.println(box);
        }
    }
}
