package ExamPreparation;

import java.util.Scanner;

public class Armory_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = fillMatrix(scanner);
        int rowOff = getRow(matrix);
        int colOff = getCol(matrix);
        playArmory(matrix, scanner, rowOff, colOff);



    }

    private static void playArmory(String[][] matrix, Scanner scanner, int rowOff, int colOff) {
        int goldCoins = 0;

        while (goldCoins < 65){
            String command = scanner.nextLine();
            matrix[rowOff][colOff] = "-";

            switch (command){
                case "up":
                    rowOff--;
                    break;
                case "down":
                    rowOff++;
                    break;
                case "left":
                    colOff--;
                    break;
                case "right":
                    colOff++;
                    break;
            }

            if (rowOff < 0 || rowOff >= matrix.length || colOff < 0 || colOff >= matrix.length){
                break;
            }

            if (matrix[rowOff][colOff].equals("M")){
                matrix[rowOff][colOff] = "-";

                for (int r = 0; r < matrix.length; r++) {
                    for (int c = 0; c < matrix.length; c++) {
                        if ("M".equals(matrix[r][c])){
                            rowOff = r;
                            colOff = c;
                        }
                    }
                }
                matrix[rowOff][colOff] = "-";
            }else if (!matrix[rowOff][colOff].equals("-")){
                int swordPrice = Integer.parseInt(matrix[rowOff][colOff]);
                goldCoins += swordPrice;
                matrix[rowOff][colOff] = "-";
            }
        }

        if (goldCoins < 65){
            System.out.println("I do not need more swords!");
        }else {
            System.out.println("Very nice swords, I will come back for more!");
            matrix[rowOff][colOff] = "A";
        }
        System.out.printf("The king paid %d gold coins.%n", goldCoins);
        print(matrix);
    }

    private static void print(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static int getCol(String[][] matrix) {
        int colOff = -1;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if ("A".equals(matrix[r][c])){
                    colOff = c;
                }
            }
        }
        return colOff;
    }

    private static int getRow(String[][] matrix) {
        int rowOff = -1;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if ("A".equals(matrix[r][c])){
                    rowOff = r;
                }
            }
        }
        return rowOff;
    }

    private static String[][] fillMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
        return matrix;
    }
}
