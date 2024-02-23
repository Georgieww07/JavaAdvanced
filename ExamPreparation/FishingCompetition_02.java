package ExamPreparation;

import java.util.Scanner;

public class FishingCompetition_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = fillMatrix(scanner);
        int[] position = getPosition(matrix);
        int row = position[0];
        int col = position[1];
        playGame(scanner, matrix, row, col);
    }

    private static void playGame(Scanner scanner, String[][] matrix, int row, int col) {
        int fishCaught = 0;
        matrix[row][col] = "-";

        while (true) {
            String command = scanner.nextLine();
            if ("collect the nets".equals(command)) {
                break;
            }

            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }
            row = checkRow(row, matrix);
            col = checkCol(col, matrix);

            if (matrix[row][col].equals("W")) {
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]%n", row, col);
                return;

            } else if (!matrix[row][col].equals("-")) {
                int amount = Integer.parseInt(matrix[row][col]);
                fishCaught += amount;

                matrix[row][col] = "-";
            }
        }

        if (fishCaught >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            int lack = 20 - fishCaught;
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", lack);
        }

        if (fishCaught > 0) {
            System.out.printf("Amount of fish caught: %d tons.%n", fishCaught);
        }

        matrix[row][col] = "S";
        print(matrix);
    }

    private static int checkCol(int col, String[][] matrix) {
        if (col < 0) {
            col = matrix.length - 1;
        } else if (col >= matrix.length) {
            col = 0;
        }
        return col;
    }

    private static int checkRow(int row, String[][] matrix) {
        if (row < 0) {
            row = matrix.length - 1;
        } else if (row >= matrix.length) {
            row = 0;
        }
        return row;
    }

    private static void print(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }


    private static int[] getPosition(String[][] matrix) {
        int[] position = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if ("S".equals(matrix[r][c])) {
                    position[0] = r;
                    position[1] = c;
                }
            }
        }
        return position;
    }

    private static String[][] fillMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        for (int r = 0; r < n; r++) {
            matrix[r] = scanner.nextLine().split("");
        }
        return matrix;
    }
}
