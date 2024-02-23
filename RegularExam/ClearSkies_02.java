package RegularExam;

import java.util.Scanner;

public class ClearSkies_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = fillMatrix(scanner);
        int[] position = getPlanePosition(matrix);
        int rowJ = position[0];
        int colJ = position[1];
        playGame(scanner, matrix, rowJ, colJ);


    }

    private static void playGame(Scanner scanner, String[][] matrix, int rowJ, int colJ) {
        int planeArmour = 300;
        int enemyPlanes = 4;
        int countHit = 0;

        matrix[rowJ][colJ] = "-";

        while (enemyPlanes != 0){
            String command = scanner.nextLine();

            switch (command){
                case "up":
                    rowJ--;
                    break;
                case "down":
                    rowJ++;
                    break;
                case "left":
                    colJ--;
                    break;
                case "right":
                    colJ++;
                    break;
            }

            if ("E".equals(matrix[rowJ][colJ])){
                matrix[rowJ][colJ] = "-";
                enemyPlanes--;

                if (enemyPlanes != 1){
                    planeArmour -= 100;
                }
                countHit++;

                if (countHit == 3){
                    System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n", rowJ, colJ);
                    break;
                }
            }else if ("R".equals(matrix[rowJ][colJ])){
                matrix[rowJ][colJ] = "-";
                if (planeArmour < 300){
                    planeArmour = 300;
                    countHit = 0;
                }
            }
        }

        if (enemyPlanes == 0){
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        }

        matrix[rowJ][colJ] = "J";
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


    private static int[] getPlanePosition(String[][] matrix) {
        int[] position = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if ("J".equals(matrix[r][c])) {
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
