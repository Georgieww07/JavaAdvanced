package MultiDimensionalArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] parameters = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = parameters[0];
        int cols = parameters[1];

        String[][] matrix = new String[rows][cols];


        char firstLast = 97;
        char mid = 97;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String result = Character.toString(firstLast) + Character.toString(mid) + Character.toString(firstLast);
                matrix[row][col] = result;

                mid++;


            }
            firstLast++;
            int midValue = row + 1 + 97;
            mid = (char)midValue;

        }


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }
    }
}
