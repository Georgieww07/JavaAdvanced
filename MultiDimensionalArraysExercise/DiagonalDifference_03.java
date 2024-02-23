package MultiDimensionalArraysExercise;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int sumPrimaryDiagonal = getSumPrimaryDiagonal(matrix);
        int sumSecondaryDiagonal = getSumSecondaryDiagonal(matrix);

        int result = Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal);
        System.out.println(result);
    }

    private static int getSumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == matrix.length - row - 1){
                    sum += matrix[row][col];
                }

            }

        }
        return sum;
    }







    private static int getSumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col){
                    sum += matrix[row][col];
                }

            }

        }
        return sum;
    }
}
