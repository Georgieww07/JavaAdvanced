package MultiDimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                            .split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        }

        int[] array = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongValue = matrix[array[0]][array[1]];

        List<int[]> correctedValues = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == wrongValue){
                    int actualValue = 0;

                    if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != wrongValue){
                        //Top
                        actualValue += matrix[r - 1][c];
                    }

                    if (isInBounds(matrix, r, c - 1) && matrix[r][c - 1] != wrongValue){
                        //left
                        actualValue += matrix[r][c - 1];
                    }

                    if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != wrongValue){
                        //down
                        actualValue += matrix[r + 1][c];
                    }

                    if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != wrongValue){
                        //right
                        actualValue += matrix[r][c + 1];
                    }

                    int[] parameters = new int[3];
                    parameters[0] = r;
                    parameters[1] = c;
                    parameters[2] = actualValue;

                    correctedValues.add(parameters);


                }

            }
        }

        for (int[] params : correctedValues) {
            matrix[params[0]][params[1]] = params[2];
            
        }

        for (int row = 0; row < matrix.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            System.out.println(sb);

        }

    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length
                && c >= 0 && c < matrix[r].length;
    }

}

