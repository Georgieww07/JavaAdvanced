package ExamPreparation;

import java.util.Scanner;

public class StickyFingers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = fillMatrix(scanner, n);
        int rowTh = getRow(matrix);
        int colTh = getCol(matrix);
        playGame(commands, matrix, rowTh, colTh);


    }

    private static void playGame(String[] commands, String[][] matrix, int rowTh, int colTh) {
        int allMoney = 0;
        matrix[rowTh][colTh] = "+";
        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];

            int rowBeforeMove = rowTh;
            int colBeforeMove = colTh;

            switch (currentCommand) {
                case "up":
                    rowTh--;
                    break;
                case "down":
                    rowTh++;
                    break;
                case "left":
                    colTh--;
                    break;
                case "right":
                    colTh++;
                    break;
            }

            if (rowTh < 0 || rowTh >= matrix.length || colTh < 0 || colTh >= matrix.length){
                rowTh = rowBeforeMove;
                colTh = colBeforeMove;

                System.out.println("You cannot leave the town, there is police outside!");
            }

            if (matrix[rowTh][colTh].equals("$")){
                matrix[rowTh][colTh] = "+";

                int moneyStolen = rowTh * colTh;
                allMoney += moneyStolen;

                System.out.printf("You successfully stole %d$.%n", moneyStolen);

            }else if (matrix[rowTh][colTh].equals("P")){
                System.out.printf("You got caught with %d$, and you are going to jail.%n", allMoney);
                matrix[rowTh][colTh] = "#";

                for (int r = 0; r < matrix.length; r++) {
                    for (int c = 0; c < matrix.length; c++) {
                        System.out.print(matrix[r][c] + " ");
                    }
                    System.out.println();
                }
                return;
            }
        }
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", allMoney);

        matrix[rowTh][colTh] = "D";
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int getCol(String[][] matrix) {
        int colTh = -1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("D")) {
                    colTh = c;
                }
            }
        }
        return colTh;
    }

    private static int getRow(String[][] matrix) {
        int rowTh = -1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("D")) {
                    rowTh = r;
                }
            }
        }
        return rowTh;
    }

    private static String[][] fillMatrix(Scanner scanner, int n) {
        String[][] matrix = new String[n][n];

        for (int r = 0; r < n; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
}
