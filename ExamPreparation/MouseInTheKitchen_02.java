package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = fillMatrix(scanner);
        int[] mousePosition = getPosition(matrix);
        int mouseRow = mousePosition[0];
        int mouseCol = mousePosition[1];
        playGame(matrix, mouseRow, mouseCol, scanner);
    }

    private static void playGame(String[][] matrix, int mouseRow, int mouseCol, Scanner scanner) {
        int countCheese = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if ("C".equals(matrix[r][c])){
                    countCheese++;
                }
            }
        }
        while (true){
            String command = scanner.nextLine();

            int mouseRowBefore = mouseRow;
            int mouseColBefore = mouseCol;

            matrix[mouseRow][mouseCol] = "*";

            if ("danger".equals(command)){
                break;
            }
            switch (command){
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }

            if (mouseRow < 0 || mouseRow >= matrix.length || mouseCol < 0 || mouseCol >= matrix[mouseRow].length){
                System.out.println("No more cheese for tonight!");
                mouseRow = mouseRowBefore;
                mouseCol = mouseColBefore;

                countCheese = -1;

                break;
            }


            String mousePosition = matrix[mouseRow][mouseCol];

            if ("C".equals(mousePosition)){
                matrix[mouseRow][mouseCol] = "*";

                countCheese--;

                if (countCheese == 0){
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    break;
                }

            }else if ("T".equals(mousePosition)){
                System.out.println("Mouse is trapped!");
                countCheese = -1;
                break;

            }else if ("@".equals(mousePosition)){
                mouseRow = mouseRowBefore;
                mouseCol = mouseColBefore;
            }
        }

        if (countCheese > 0){
            System.out.println("Mouse will come back later!");
        }
        matrix[mouseRow][mouseCol] = "M";
        print(matrix);
    }

    private static void print(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }


    private static int[] getPosition(String[][] matrix) {
        int[] position = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if ("M".equals(matrix[r][c])){
                    position[0] = r;
                    position[1] = c;
                }
            }
        }
        return position;
    }

    private static String[][] fillMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().split("");
        }

        return matrix;
    }
}
