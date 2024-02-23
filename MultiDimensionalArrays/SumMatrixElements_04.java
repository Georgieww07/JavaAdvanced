package MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int [] dimensions = Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] array = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            array[row] = Arrays.stream(scanner.nextLine()
                    .split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
        System.out.println(rows);
        System.out.println(cols);


        printSum(array);
    }

    public static void printSum(int[][] array){
        int sum = 0;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                sum += array[row][col];

            }

        }
        System.out.println(sum);
    }
}
