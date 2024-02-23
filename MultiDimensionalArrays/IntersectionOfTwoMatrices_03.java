package MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstArray = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            firstArray[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        char[][] secondArray = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            secondArray[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();

        }
        char[][] result = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstArray[row][col] == secondArray[row][col]){
                    result[row][col] = firstArray[row][col];
                }else {
                    result[row][col] = '*';
                }

            }

        }


        for (int row = 0; row < result.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < result[row].length; col++) {
                sb.append(result[row][col]).append(" ");
            }
            System.out.println(sb);

        }
    }
}
