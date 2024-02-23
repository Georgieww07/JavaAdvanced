package MultiDimensionalArrays;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] array = new int[dimensions[0]][dimensions[1]];
        for (int row = 0; row < dimensions[0]; row++) {
            array[row] = Arrays.stream(scanner.nextLine()
                            .split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
        int[][] result = new int[2][2];

        int sum = Integer.MIN_VALUE;
        for (int row = 0; row < array.length - 1; row++) {
            for (int col = 0; col < array[row].length - 1; col++) {
                int currSum = array[row][col] + array[row][col + 1] + array[row + 1][col] + array[row + 1][col + 1];
                if (currSum > sum){
                    sum = currSum;
                    result[0][0] = array[row][col];
                    result[0][1] = array[row][col + 1];
                    result[1][0] = array[row + 1][col];
                    result[1][1] = array[row + 1][col + 1];
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
        System.out.println(sum);
    }
}
