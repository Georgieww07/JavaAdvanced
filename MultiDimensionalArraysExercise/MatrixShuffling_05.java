package MultiDimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");


        }

        String input = scanner.nextLine();
        while (!"END".equals(input)){
            String[] commandParts = input.split("\\s+");

            if (isValidInput(commandParts, rows, cols)){
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                String firstNumber = matrix[row1][col1];
                String secondNumber = matrix[row2][col2];

                matrix[row1][col1] = secondNumber;
                matrix[row2][col2] = firstNumber;



                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();

                }
            }else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }

    }



    private static boolean isValidInput(String[] commandParts, int rows, int cols) {

        if (commandParts.length != 5){
            return false;
        }

        if (!"swap".equals(commandParts[0])){
            return false;
        }


        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);


        return (row1 >= 0 && row1 < rows && col1 >= 0 && col1 < cols &&
            row2 >= 0 && row2 < rows && col2 >=0 && col2 <cols);

    }
}




















