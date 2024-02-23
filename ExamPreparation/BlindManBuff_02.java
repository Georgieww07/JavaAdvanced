package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class BlindManBuff_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] playground = fillPlayground(scanner);
        int row = getRow(playground);
        int col = getCol(playground);
        playGame(playground, row, col, scanner);

    }
    private static void playGame(String[][] playground, int row, int col, Scanner scanner) {
        int countMoves = 0;
        int countTouchedPlayers = 0;

        while (true) {
            String command = scanner.nextLine();
            if ("Finish".equals(command)) {
                break;
            }

            int lastRow = row;
            int lastCol = col;

            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }

            if (row >= 0 && row < playground.length && col >= 0 && col < playground[0].length && !playground[row][col].equals("O")) {
                if (playground[row][col].equals("P")) {
                    countMoves++;
                    countTouchedPlayers++;
                    playground[row][col] = "-";
                } else {
                    if (countTouchedPlayers == 3) {
                        break;
                    } else {
                        countMoves++;
                    }
                }
            } else {
                row = lastRow;
                col = lastCol;

            }

        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", countTouchedPlayers, countMoves);
    }

    private static int getCol(String[][] playground) {
        int col = 0;
        for (int r = 0; r < playground.length; r++) {
            for (int c = 0; c < playground[r].length; c++) {
                if ("B".equals(playground[r][c])) {
                    col = c;
                }
            }
        }
        return col;
    }

    private static int getRow(String[][] playground) {
        int row = 0;
        for (int r = 0; r < playground.length; r++) {
            for (int c = 0; c < playground[r].length; c++) {
                if ("B".equals(playground[r][c])) {
                    row = r;
                }
            }
        }
        return row;
    }

    private static String[][] fillPlayground(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = dimensions[0];
        int m = dimensions[1];

        String[][] playground = new String[n][m];

        for (int row = 0; row < n; row++) {
            playground[row] = scanner.nextLine().split("\\s+");
        }
        return playground;
    }
}
