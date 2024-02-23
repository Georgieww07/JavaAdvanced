package ExamPreparation;

import java.util.Scanner;

public class RallyRacing_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();
        String[][] matrix = fillMatrix(scanner, n);

        rally(matrix, carNumber, scanner);


    }

    private static void rally(String[][] matrix, String carNumber, Scanner scanner) {
        int rowCar = 0;
        int colCar = 0;

        int kilometers = 0;

        while (true){
            String command = scanner.nextLine();
            if ("End".equals(command)){
                break;
            }

            switch (command){
                case "up":
                    rowCar--;
                    break;
                case "down":
                    rowCar++;
                    break;
                case "left":
                    colCar--;
                    break;
                case "right":
                    colCar++;
                    break;
            }

            if (matrix[rowCar][colCar].equals(".")){
                kilometers += 10;
            }else if (matrix[rowCar][colCar].equals("T")){
                matrix[rowCar][colCar] = ".";

                for (int r = 0; r < matrix.length; r++) {
                    for (int c = 0; c < matrix.length; c++) {
                        if (matrix[r][c].equals("T")){
                            rowCar = r;
                            colCar = c;
                        }
                    }
                }
                matrix[rowCar][colCar] = ".";
                kilometers += 30;
            }else if (matrix[rowCar][colCar].equals("F")){
                kilometers += 10;
                matrix[rowCar][colCar] = "C";
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                System.out.printf("Distance covered %d km.%n", kilometers);
                print(matrix);
                return;
            }
        }

        System.out.printf("Racing car %s DNF.%n", carNumber);
        System.out.printf("Distance covered %d km.%n", kilometers);
        matrix[rowCar][colCar] = "C";
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


    private static String[][] fillMatrix(Scanner scanner, int n) {
        String[][] matrix = new String[n][n];

        for (int r = 0; r < n; r++) {
                matrix[r] = scanner.nextLine().split("\\s+");
            }
        return matrix;
    }
}
