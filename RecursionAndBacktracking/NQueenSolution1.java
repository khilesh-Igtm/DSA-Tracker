public class NQueenSolution1 {
// This is not the optimised way of finding n queens bcz at libe 16-17
// we are placing the queen in the board and before placing we are checking is the position safe for them
// so inside isafe function we check for diagonal , upper , left and other direction too.
// we are just increasing the complexity as issafe function is already inside the for loop
// and inside issafe function we are having multiple loops for checking in different directions.
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        System.out.println(countWays(board, 0));
    }

    // this will tell in how many ways we can place the queen
    static int countWays(boolean[][] board, int currentRow) {
        int count = 0;
        if (currentRow == board.length) {
            System.out.println("Total queen placed: " + getCount(board));
            return 1;
        }
        for (int col = 0; col < board[currentRow].length; col++) {
            if (isSafeArea(board, currentRow, col)) {
                board[currentRow][col] = true;
                count = count + countWays(board, currentRow + 1); // main line for recursion
                // this is the only line we have to do the backtracking, when the queen will not
                // be at the right place
                board[currentRow][col] = false;
            }
        }

        return count;
    }

    // this will check if I can place the queen there or not
    static boolean isSafeArea(boolean[][] board, int row, int col) {

        // checking if there is a queen in the same upper col
        for (int i = row; i >= 0; i--) {
            // will check is there any already Q in this row or not by decreasing i .
            // for 1st case we place Q at 1st position then currentROw become 1
            // we check in this condition by checking the previous row i.e (0,0) and we
            // are currently at (1,0).
            if (board[i][col]) {
                return false;
            }
        }

        // checking in the upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // checking in the upper right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        // if we can place queen ----
        return true;
    }

    static int getCount(boolean[][] board) {
        int countDown = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col]) {
                    System.out.println(board[row][col] + "\t" + row + "," + col);
                    countDown++;
                }
            }
        }
        return countDown;
    }

}