import java.util.LinkedList;
import java.util.List;

/**
 * Board definition for the 8 Puzzle challenge
 */
public class Board {

    private int n;
    public int[][] tiles;

    //TODO
    // Create a 2D array representing the solved board state
    private int[][] goal = {{1,2,3}, {4,5,6}, {7,8,0}};

    /*
     * Set the global board size and tile state
     */
    public Board(int[][] b) {
        tiles = b;
        n = this.tiles.length;
    }

    /*
     * Size of the board 
     (equal to 3 for 8 puzzle, 4 for 15 puzzle, 5 for 24 puzzle, etc)
     */
    private int size() {
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

    /*
     * Sum of the manhattan distances between the tiles and the goal
     */
    public int manhattan() {
        for (int i=0; i < tiles.length; i++) {
            for (int j=0; j < tiles.length; j++) {
                if (tiles[i][j] != goal[i][j] && tiles[i][j] !=0) {                         //if the tile and goal aren't the same
                    int[] goalLocation = getIndices(tiles[i][j], goal);                     //grab the goal location using getIndices
                    return (Math.abs(i-goalLocation[0])) + Math.abs((j-goalLocation[0]));   //return the distance between the current location and goal location, in both x+y directions
                }
            }
        }
        return 0;                                                                          //if they're referring to the same tile so manhattan distance = 0
    }

    /*
     * Compare the current state to the goal state
     */
    public boolean isGoal() {
        Board solvedB = new Board(goal);
        return equals(solvedB);
    }

    /*
     * Returns true if the board is solvable
     * Research how to check this without exploring all states
     */
    public boolean solvable() {
        if (manhattan() % 2 == 0) return true;     //if manhattan is even, solvable
        return false;                              //if odd, not solvable
    }

    public Board swapTiles(int i, int j, int n, int m){
        return null;
    }

    /*
     * Return all neighboring boards in the state tree
     */
    public Iterable<Board> neighbors() {
        int[] location = getIndices(0, this.tiles);
        return null;
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
}
