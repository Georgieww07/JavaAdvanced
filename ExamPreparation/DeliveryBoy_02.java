package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = fillMatrix(scanner);
        int rowBoy = getRow(matrix);
        int colBoy = getCol(matrix);
        deliverPizza(matrix, rowBoy, colBoy, scanner);

    }

    private static void deliverPizza(String[][] matrix, int rowBoy, int colBoy, Scanner scanner) {

        int initialRow = rowBoy;
        int initialCol = colBoy;
        while (true){
            String command = scanner.nextLine();
            int rowBeforeMove = rowBoy;
            int colBeforeMove = colBoy;
            switch(command){
                case "up":
                    rowBoy--;
                    break;
                case "down":
                    rowBoy++;
                    break;
                case "left":
                    colBoy--;
                    break;
                case "right":
                    colBoy++;
                    break;
            }

            if (rowBoy < 0 || rowBoy >= matrix.length || colBoy < 0 || colBoy >= matrix[rowBoy].length){
                System.out.println("The delivery is late. Order is canceled.");

                matrix[initialRow][initialCol] = " ";

                for (int r = 0; r < matrix.length; r++) {
                    for (int c = 0; c < matrix[r].length; c++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            }

            if (matrix[rowBoy][colBoy].equals("*")){
                rowBoy = rowBeforeMove;
                colBoy = colBeforeMove;
            }else if (matrix[rowBoy][colBoy].equals("P")){
                matrix[rowBoy][colBoy] = "R";
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            }else if (matrix[rowBoy][colBoy].equals("A")){
                matrix[rowBoy][colBoy] = "P";
                System.out.println("Pizza is delivered on time! Next order...");

                for (int r = 0; r < matrix.length; r++) {
                    for (int c = 0; c < matrix[r].length; c++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;

            }else if (matrix[rowBoy][colBoy].equals("-")){
                matrix[rowBoy][colBoy] = ".";
            }
        }
    }

    private static int getCol(String[][] matrix) {
        int col = -1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if ("B".equals(matrix[r][c])){
                    col = c;
                }
            }
        }
        return col;
    }

    private static int getRow(String[][] matrix) {
        int row = -1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if ("B".equals(matrix[r][c])){
                    row = r;
                }
            }
        }
        return row;
    }


    private static String[][] fillMatrix(Scanner scanner){
        int[] dimensions = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            String[] tokens = scanner.nextLine().split("");
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = tokens[c];

            }
        }
        return matrix;
    }
}
