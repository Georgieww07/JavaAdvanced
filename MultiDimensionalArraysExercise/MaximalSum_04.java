package MultiDimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] dimensions = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();


        }

        int[][] result = new int[3][3];

        int maxSum3x3 = getMaxSumOf3X3(matrix, rows, cols, result);

        System.out.println("Sum = " + maxSum3x3);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();

        }

    }

    private static int getMaxSumOf3X3(int[][] matrix, int rows, int cols, int[][] result) {

        int sum = Integer.MIN_VALUE;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = 0;
                currentSum += matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > sum){
                    sum = currentSum;

                    result[0][0] = matrix[row][col];
                    result[0][1] = matrix[row][col + 1];
                    result[0][2] = matrix[row][col + 2];

                    result[1][0] = matrix[row + 1][col];
                    result[1][1] = matrix[row + 1][col + 1];
                    result[1][2] = matrix[row + 1][col + 2];

                    result[2][0] = matrix[row + 2][col];
                    result[2][1] = matrix[row + 2][col + 1];
                    result[2][2] = matrix[row + 2][col + 2];
                }


            }

        }
        return sum;
    }
}
