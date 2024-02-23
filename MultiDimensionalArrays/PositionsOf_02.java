package MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] dimensions = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] array = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            array[row] = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int number = Integer.parseInt(scanner.nextLine());


        isFound(array, number);


    }
    public static void isFound(int[][] array, int number){
        boolean isFound = false;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == number){
                    isFound = true;
                    System.out.println(row + " " + col);

                }

            }
        }

        if(!isFound){
            System.out.println("not found");
        }
    }
}
