package MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        int[][] array = new int[n][n];
        for (int row = 0; row < n; row++) {
            array[row] = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }

        int[][] result = new int[2][n];

        int col = 0;
        int topLeftBottomRight = 0;

        int bottomLeftToRight = n - 1;
        for (int i = 0; i < n; i++) {

                result[0][col] = array[topLeftBottomRight][col];
                result[1][col] = array[bottomLeftToRight][col];

            col++;
            topLeftBottomRight++;
            bottomLeftToRight--;
        }

        for (int row = 0; row < result.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int column = 0; column < result[row].length; column++) {
                sb.append(result[row][column]).append(" ");
            }
            System.out.println(sb);

        }



    }
}
