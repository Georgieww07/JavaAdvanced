package RegularExam;

import java.util.*;

public class CheatSheet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //1. Stacks and Queues

        //Integer Stack
        Deque<Integer> integerStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> integerStack.push(e));




        //Integer Queue
        Deque<Integer> integerQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> integerQueue.offer(e));






        //Double Stack
        Deque<Double> doubleStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Double::parseDouble)
                .forEach(e -> doubleStack.push(e));






        //Double Queue
        Deque<Double> doubleQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Double::parseDouble)
                .forEach(e -> doubleQueue.offer(e));







        //Принтиране на Stack reversed
        Stack<Integer> stackToReverse = new Stack<>();
        Collections.reverse(stackToReverse);
        System.out.println(stackToReverse.toString().replace("[", "").replace("]", ""));







        //2.Matrix
        int rows = 4;
        int cols = 4;

        String[][] matrix = new String[rows][cols];

        //Read a matrix
        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }


        //Print a matrix
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }




        //Method fillMatrix SQUARE
        String[][] matrix1 = fillMatrixSquare(scanner);


        //Method fillMatrix RECTANGLE
        String[][] matrix2 = fillMatrixRectangle(scanner);


        //Method getPlayerPosition  CHECK WHAT MATRIX YOU HAVE TO USE!
        int[] position = getPlayerPosition(matrix);
        int row = position[0];
        int col = position[1];










        // Движения в матрица
        //нагоре -> ред - 1
        //надолу -> ред + 1
        //дясно -> колона + 1
        //ляво-> колона - 1


        // Валидиране на индекси
        //колона -> колона >= 0 и колона < брой колони
        //ред -> ред >= 0 и ред < брой редове












    }

    //GET POSITION
    private static int[] getPlayerPosition(String[][] matrix) {
        int[] position = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if ("S".equals(matrix[r][c])) {
                    position[0] = r;
                    position[1] = c;
                }
            }
        }
        return position;
    }

    //SQUARE
    private static String[][] fillMatrixSquare(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix1 = new String[n][n];

        for (int r = 0; r < n; r++) {
            matrix1[r] = scanner.nextLine().split("\\s+");
        }
        return matrix1;
    }


//RECTANGLE
    private static String[][] fillMatrixRectangle(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = dimensions[0];
        int m = dimensions[1];

        String[][] matrix2 = new String[n][m];

        for (int row = 0; row < n; row++) {
            matrix2[row] = scanner.nextLine().split("\\s+");
        }
        return matrix2;
    }
}
