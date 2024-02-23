package ExamPreparation;

import java.util.Scanner;

public class TheGambler_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] gameBoard = new String[n][n];
        for (int row = 0; row < n; row++) {
            gameBoard[row] = scanner.nextLine().split("");
        }

        int row = getGamblerRow(n, gameBoard);
        int col = getGamblerCol(n, gameBoard);
        int amount = 100;


        while (true){
            String command = scanner.nextLine();
            if ("end".equals(command)){
                break;
            }

            gameBoard[row][col] = "-";
            switch (command){
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

            if (row < 0 || row > gameBoard.length - 1){
                System.out.println("Game over! You lost everything!");
                break;
            }
            if (col < 0 || col > gameBoard.length - 1){
                System.out.println("Game over! You lost everything!");
                break;
            }

            String letter = gameBoard[row][col];
            switch (letter){
                case "W":
                    amount += 100;
                    break;
                case "P":
                    amount -= 200;
                    break;
                case "J":
                    amount += 100_000;

                    System.out.println("You win the Jackpot!");
                    System.out.printf("End of the game. Total amount: %d$%n", amount);
                    gameBoard[row][col] = "G";
                    printGamble(gameBoard, n);
                    return;
            }

            if (amount <= 0){
                System.out.println("Game over! You lost everything!");
                gameBoard[row][col] = "G";
                break;
            }
        }

        if (amount > 0){
            System.out.printf("End of the game. Total amount: %d$%n", amount);
            gameBoard[row][col] = "G";
            printGamble(gameBoard, n);
        }

    }


    private static void printGamble(String[][] gameBoard, int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(gameBoard[row][col]);
            }
            System.out.println();

        }
    }

    private static int getGamblerCol(int n, String[][] gameBoard) {
        int colG = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (gameBoard[row][col].equals("G")){
                    colG = col;
                }
            }
        }
        return colG;
    }

    private static int getGamblerRow(int n, String[][] gameBoard){
        int rowG = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (gameBoard[row][col].equals("G")){
                    rowG = row;
                }
            }
        }
        return rowG;
    }
}
