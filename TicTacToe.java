public class TicTacToe {

    // The number of empty spaces in the board.
    private static int spacesLeft;

    private static char[][] board = new char[3][3];

    public static void main (String[] args) {
        // Welcome the users, create and draw an empty board,
        // the first move belongs to X.
        System.out.println("Welcome to Tic Tac Toe");
        initializeBoard();
        firstDraw();
        char mark = 'X';

        while (true) {
            int square = getLegalMove(mark);
            move(square, mark);
            draw();
            if (isThreeInRow(mark)) {
                System.out.println(mark + " wins!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("Tie game!");
                break;
            }

            if (mark == 'X') {
                mark = 'O';
            }
            else {
                mark = 'X';
            }
        }
    }

    public static int getLegalMove (char mark) {
        java.util.Scanner console = new java.util.Scanner(System.in);
        while (true) {
            System.out.println(mark + "'s next move: ");
            int square = console.nextInt();
            if ((square >= 1) &&
                    (square <= 9) &&
                    (isSquareEmpty(square))) {
                return square;
            }
            System.out.println("\nIllegal move, try again\n");
        }
    }

    // Initializes the board to be empty.
    public static void initializeBoard () {
        spacesLeft = 9;

        board[0][0] = board[0][1] = board[0][2] = ' ';
        board[1][0] = board[1][1] = board[1][2] = ' ';
        board[2][0] = board[2][1] = board[2][2] = ' ';
    }

    // Post: Draws the board to standard output (screen) with the
    //       square numbers
    public static void firstDraw () {
        System.out.println();
        System.out.println("   |   |   ");
        System.out.println(" " + 1 + " | " + 2 + " | " + 3);
        System.out.println("   |   |   ");
        System.out.println("---+---+---");
        System.out.println("   |   |   ");
        System.out.println(" " + 4 + " | " + 5 + " | " + 6);
        System.out.println("   |   |   ");
        System.out.println("---+---+---");
        System.out.println("   |   |   ");
        System.out.println(" " + 7 + " | " + 8 + " | " + 9);
        System.out.println("   |   |   ");
        System.out.println();
    }

    // Post: Draws the board to the standard output
    public static void draw () {

        System.out.println();
        System.out.println("   |   |   ");
        System.out.println(" " + board[0][0] + " | "
                + board[0][1] + " | " + board[0][2]);
        System.out.println("   |   |   ");
        System.out.println("---+---+---");
        System.out.println("   |   |   ");
        System.out.println(" " + board[1][0] + " | "
                + board[1][1] + " | " + board[1][2]);
        System.out.println("   |   |   ");
        System.out.println("---+---+---");
        System.out.println("   |   |   ");
        System.out.println(" " + board[2][0] + " | "
                + board[2][1] + " | " + board[2][2]);
        System.out.println("   |   |   ");
        System.out.println();
    }

    // Pre:  mark is 'X' or 'O'
    //       1 <= square <= 9
    // Post: Stores the specified mark in the specified
    //       square of the board
    public static void move (int square, char mark) {
        if (isSquareEmpty(square)) { //Wait is this line even necessary?
            spacesLeft = spacesLeft - 1;
        }

        if (square == 1) {
            board[0][0] = mark;
        }
        else if (square == 2) {
            board[0][1] = mark;
        }
        else if (square == 3) {
            board[0][2] = mark;
        }
        else if (square == 4) {
            board[1][0] = mark;
        }
        else if (square == 5) {
            board[1][1] = mark;
        }
        else if (square == 6) {
            board[1][2] = mark;
        }
        else if (square == 7) {
            board[2][0] = mark;
        }
        else if (square == 8) {
            board[2][1] = mark;
        }
        else if (square == 9) {
            board[2][2] = mark;
        }
    }

    // Pre:  1 <= square <= 9
    // Post: Returns true if the specified square of the
    //       board is empty; returns false otherwise.
    public static boolean isSquareEmpty (int square) {

        if (square == 1) {
            return board[0][0] == ' ';
        }
        else if (square == 2) {
            return board[0][1] == ' ';
        }
        else if (square == 3) {
            return board[0][2] == ' ';
        }
        else if (square == 4) {
            return board[1][0] == ' ';
        }
        else if (square == 5) {
            return board[1][1] == ' ';
        }
        else if (square == 6) {
            return board[1][2] == ' ';
        }
        else if (square == 7) {
            return board[2][0] == ' ';
        }
        else if (square == 8) {
            return board[2][1] == ' ';
        }
        else if (square == 9) {
            return board[2][2] == ' ';
        }
        else {
            return false;
        }
    }

    // Pre:  mark is 'X' or 'O'
    // Post: Returns true if the board contains three of
    //       the specified mark in a row; returns false
    //       otherwise.
    public static boolean isThreeInRow (char mark) {

        return
                (board[0][0] == mark && board[0][1] == mark && board[0][2] == mark) ||
                        (board[1][0] == mark && board[1][1] == mark && board[1][2] == mark) ||
                        (board[2][0] == mark && board[2][1] == mark && board[2][2] == mark) ||
                        (board[0][0] == mark && board[1][0] == mark && board[2][0] == mark) ||
                        (board[0][1] == mark && board[1][1] == mark && board[2][1] == mark) ||
                        (board[0][2] == mark && board[1][2] == mark && board[2][2] == mark) ||
                        (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
                        (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark);
    }

    // Post: Returns true if the board contains no empty
    //       spaces; returns false otherwise.
    public static boolean isBoardFull () {
        return spacesLeft == 0;
    }

}
