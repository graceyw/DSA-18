import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Board definition for the 8 Puzzle challenge
 */
public class Board {

    private int n;
    public int[][] tiles;
    public int misplacedTiles;

    // Create a 2D array representing the solved board state
    private int[][] goal = {{1,2,3}, {4,5,6}, {7,8,0}};

    /*
     * Set the global board size and tile state
     */
    public Board(int[][] b) {
        tiles = b;
        n = this.tiles.length;
        misplacedTiles = this.numMisplaced();
    }

    /*
     * Size of the board 
     (equal to 3 for 8 puzzle, 4 for 15 puzzle, 5 for 24 puzzle, etc)
     */
    public int size() {
        return tiles.length;
    }

    public int[] getIndices(int num, int[][] board) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (board[i][j] == num) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int numMisplaced(){
        int nM = 0;

        for (int i=0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j] != goal[i][j] && tiles[i][j] != 0) {
                    nM += 1;
                }
            }
        }
        return nM;
    }

    /*
     * Sum of the manhattan distances between the tiles and the goal
     */
    public int manhattan() {
        int finalMan = 0;
        for (int i=0; i < tiles.length; i++) {
            for (int j=0; j < tiles.length; j++) {
                if (tiles[i][j] != goal[i][j] && tiles[i][j] != 0) {                         //if the tile and goal aren't the same
                    int[] goalLocation = getIndices(tiles[i][j], goal);                     //grab the goal location using getIndices
                    finalMan += (Math.abs(i-goalLocation[0])) + Math.abs((j-goalLocation[1])); //the distance between the current location and goal location, in both x+y directions

                }
            }
        }
        System.out.print("Manhattan: ");
        System.out.println(finalMan);
        return finalMan;                                                                          //if they're referring to the same tile so manhattan distance = 0
    }

    /*
     * Compare the current state to the goal state
     */
    public boolean isGoal() {
        Board solvedB = new Board(goal);
        return equals(solvedB);
    }

    /*
     * Coverts 2d board to 1d array
     */
    public List<Integer> lineBoard(){
        List<Integer> finalLine = new ArrayList<>();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (this.tiles[i][j] != 0){
                    finalLine.add(this.tiles[i][j]);
                }
            }
        }
        return finalLine;
    }

    /*
     * Returns number of inversions in board
     */
    public int getInvCount()
    {
        List<Integer> Line = lineBoard(); // converts 2d array to 1d array
        int inv_count = 0;
        for (int i = 0; i < n*n- 2; i++) {
            for (int j = i + 1; j < n*n-1; j++) {
                if (Line.get(i) > Line.get(j)) { //checks whether item at position i is greater than the one after it
                    inv_count++;
                }
            }
        }
        return inv_count;
    }

    /*
     * Returns true if the board is solvable
     * Research how to check this without exploring all states
     */
    public boolean solvable() {
        if (this.getInvCount() % 2 == 0) return true;     //if invCount is even, solvable
        return false;                              //if odd, not solvable
    }

    public Board swapTiles(int i, int j, int n, int m){
        int[][] tempB = copyOf(this.tiles);
        int tile1 = tempB[i][j];
        int tile2 = tempB[n][m];
        tempB[i][j] = tile2;
        tempB[n][m] = tile1;
        return new Board(tempB);
    }

    /*
     * Return all neighboring boards in the state tree
     */
    public Iterable<Board> neighbors() {
        List<Board> lBoard = new ArrayList<>();
        int[] location = getIndices(0, this.tiles);
        int i = location[0];
        int j = location[1];

        if (i>0) {
            lBoard.add(swapTiles(i, j, i - 1, j));
        }
        if (i<n-1) {
            lBoard.add(swapTiles(i, j, i + 1, j));
        }
        if (j>0) {
            lBoard.add(swapTiles(i, j, i, j - 1));
        }
        if (j<n-1) {
            lBoard.add(swapTiles(i, j, i, j + 1));
        }

        Iterable<Board> iter = lBoard;
        return iter;
    }

    /**
     * Creates a deep copy of the input array and returns it
     */
    private static int[][] copyOf(int[][] A) {
        int[][] B = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }

    /*
     * Check if this board equals a given board state
     */
    @Override
    public boolean equals(Object x) {
        // Check if the board equals an input Board object
        if (x == this) return true;
        if (x == null) return false;
        if (!(x instanceof Board)) return false;
        // Check if the same size
        Board y = (Board) x;
        if (y.tiles.length != n || y.tiles[0].length != n) {
            return false;
        }
        // Check if the same tile configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != y.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can include whatever output you find useful
        int[][] initState = {{1, 2, 3}, {4, 0, 6}, {7, 8, 5}};
        Board board = new Board(initState);

        System.out.println("Size: " + board.size());
        System.out.println("Solvable: " + board.solvable());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("Is goal: " + board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
    }

    public void displayBoard(){
        for (int i = 0; i<n; i++){
            System.out.println(Arrays.toString(this.tiles[i]));
        }
        System.out.println("");
    }
}
