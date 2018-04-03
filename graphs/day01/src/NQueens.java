import java.util.ArrayList;
import java.util.List;

public class NQueens {


    /**
     * Checks the 45° and 135° diagonals for an existing queen. For example, if the board is a 5x5
     * and you call checkDiagonal(board, 3, 1), The positions checked for an existing queen are
     * marked below with an `x`. The location (3, 1) is marked with an `o`.
     *
     * ....x
     * ...x.
     * x.x..
     * .o...
     * .....
     *
     * Returns true if a Queen is found.
     *
     * Do not modify this function (the tests use it)
     */
    public static boolean checkDiagonal(char[][] board, int r, int c) {
        int y = r - 1;
        int x = c - 1;
        while (y >= 0 && x >= 0) {
            if (board[y][x] == 'Q') return true;
            x--;
            y--;
        }
        y = r - 1;
        x = c + 1;
        while (y >= 0 && x < board[0].length) {
            if (board[y][x] == 'Q') return true;
            x++;
            y--;
        }
        return false;
    }

    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }

    public static void recurse(char[][] board, int currRow, boolean[] columns, List<char[][]> answers) {
        if (currRow == board.length) {
            answers.add(copyOf(board));
            return;
        }
        for (int col=0; col<board.length; col++) {
            if (!columns[col] && !checkDiagonal(board, currRow, col)) {      //if there is not a queen in that row and col
                board[currRow][col] = 'Q';                                  //add queen
                columns[col] = true;
                recurse(board, currRow+1, columns, answers);        //recurse
                board[currRow][col] = '.';                                 //immediately undo
                columns[col] = false;
            }
        }
    }

    // "An upperbound" for # of solutions: N! because you have (N choices in row 0) * (N-1 choices in row 1) * (N-2 choices in row 2)...etc
    // Runtime: David says "probably" N^2 * N! ("Depending on how much you believe me...many times have I been wrong")
    public static List<char[][]> nQueensSolutions(int n) {
        boolean[] columns = new boolean[n];     //automatically store all falses in the beginning, so we're good
        char[][] board = new char[n][n];        //auto initializes ints as 0s
        for (int row=0; row<n; row++) {         //so make them . instead to show no queen
            for (int col=0; col<n; col++) {
                board[row][col] = '.';
            }
        }
        List<char[][]> answers = new ArrayList<>();
        recurse(board,0,columns,answers);
        return answers;
    }

}
