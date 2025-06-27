package TicTacToe;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        char currentPlayer = 'X';
        boolean gameEnded = false;
        Scanner scan = new Scanner(System.in);

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + " , enter your row(0, 1, 2): ");
            int row = scan.nextInt();
            System.out.println("Player " + currentPlayer + " , enter your column(0, 1, 2): ");
            int col = scan.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                printBoard();

                if (checkWin(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Cell already taken! Try again.");
            }
        }

        scan.close();
    }

    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void printBoard() {
        System.out.println("--------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("--------------");
        }
    }

    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
                return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}
