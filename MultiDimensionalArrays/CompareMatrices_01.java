package MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] paramsFirst = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rowsFirst = paramsFirst[0];
        int colsFirst = paramsFirst[1];


        int[][] multiArray1 = new int[rowsFirst][colsFirst];
        for (int rowFirst = 0; rowFirst < rowsFirst; rowFirst++) {
            String[] tokens1 = scanner.nextLine().split(" ");
            for (int colFirst = 0; colFirst < colsFirst; colFirst++) {
                multiArray1[rowFirst][colFirst] = Integer.parseInt(tokens1[colFirst]);

            }

        }




        int[] params2 = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rowsSecond = params2[0];
        int colsSecond = params2[1];


        int[][] multiArray2 = new int[rowsSecond][colsSecond];
        for (int rowSecond = 0; rowSecond < rowsSecond; rowSecond++) {
            String[] tokens2 = scanner.nextLine().split(" ");
            for (int colSecond = 0; colSecond < colsSecond; colSecond++) {
                multiArray2[rowSecond][colSecond] = Integer.parseInt(tokens2[colSecond]);

            }

        }

        if (rowsFirst != rowsSecond){
            System.out.println("not equal");
        }else if (colsFirst != colsSecond){
            System.out.println("not equal");
        }else {
            if (areEqual(multiArray1, multiArray2)){
                System.out.println("equal");
            }else {
                System.out.println("not equal");
            }
        }



    }
    public static boolean areEqual(int[][] array1, int[][] array2){
        for (int row  = 0; row < array1.length; row++) {
            for (int col = 0; col < array1[row].length; col++) {
                if (array1[row][col] != array2[row][col]){
                    return false;
                }

            }

        }
        return true;
    }
}
