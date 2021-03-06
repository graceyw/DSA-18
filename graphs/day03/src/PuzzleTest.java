import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for 8 Puzzle functionality
 */


public class PuzzleTest {

    private Board board;

    @BeforeEach
    public void setUp() throws Exception {
        int[][] initState = {{1, 2, 3}, {4, 6, 0}, {7, 5, 8}};
        board = new Board(initState);
    }

    // Test board methods

    /**
     * Test method for Iterable<Board> neighbors()
     */
    @Test
    public void testNeighbors(){
        List<Board> neighborBoards = new ArrayList<>();
        int[][] n1 = {{1,2,0},{4,6,3}, {7,5,8}};
        neighborBoards.add(new Board(n1));

        int[][] n2 = {{1,2,3},{4,0,6}, {7,5,8}};
        neighborBoards.add(new Board(n2));

        int[][] n3 = {{1,2,3},{4,6,8}, {7,5,0}};
        neighborBoards.add(new Board(n3));

        Iterator<Board> neigh = board.neighbors().iterator();

        List<Board> copy = new ArrayList<Board>();
        while (neigh.hasNext())
            copy.add(neigh.next());
        int equal = 0;
        if (copy.size() == neighborBoards.size()){

            for (int j = 0; j< copy.size(); j++){
                for (int l = 0; l<neighborBoards.size(); l++) {
                    if (compareBoard(copy.get(j), neighborBoards.get(l))) {
                        equal += 1;
                    }
                }
            }
        }
        assertEquals(equal, neighborBoards.size());


    }

    /**
     * Helper fxn to compare boards.
     */
    public boolean compareBoard(Board board1, Board board2){
        return Arrays.deepEquals(board1.tiles, board2.tiles);
    }

    /**
     * Test method for void manhattan().
     */
    @Test
    public void testManhattan() {
        assertEquals(board.manhattan(), 3);
    }

    /**
     * Test method for void manhattan().
     */
    @Test
    public void testSolvable() {
        int[][] initState1 = {{1, 8, 2}, {0, 4,3}, {7, 6, 5}};
        Board newboard1 = new Board(initState1);
        assertEquals(true, newboard1.solvable());

        int[][] initState2 = {{8, 1, 2}, {0, 4,3}, {7, 6, 5}};
        Board newboard2 = new Board(initState2);
        assertEquals(false, newboard2.solvable());
    }

    /**
     * Test method for boolean isGoal().
     */
    @Test
    public void testGoal() {
        assertEquals(board.isGoal(), false);
    }

    /**
     //     * Test method for Solver - Unsolvable puzzle
     //     */
    @Test
    public void testOurs() {
        // Unsolvable puzzle
        int[][] initState = {{7, 1, 4}, {5, 8, 3}, {0, 2, 6}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
    }

    // Test solver with several initial board states

    /**
//     * Test method for Solver - Unsolvable puzzle
//     */
    @Test
    public void testSolverUnsolvable() {
        // Unsolvable puzzle
        int[][] initState = {{1, 0, 3}, {2, 4, 5}, {6, 7, 8}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), false);
        solver = new Solver(new Board(new int[][]{{1, 8, 2},{0,4,3},{7,6,5}}));
        assertEquals(solver.isSolvable(), true);
        solver = new Solver(new Board(new int[][]{{8, 1, 2},{0,4,3},{7,6,5}}));
        assertEquals(solver.isSolvable(), false);
    }

    /**
     * Test method for Solver - Easy puzzle
     */
    @Test
    public void testSolverEasy() {
        // Easy solve puzzle
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Create solution boards list
        assertEquals(1, solver.minMoves);
    }

    @Test
    public void testSolverAverage() {
        int[][] initState = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 4);
    }


    @Test
    public void testSolverMedium() {
        int[][] initState = {{2, 3, 6}, {1, 5, 0}, {4, 7, 8}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 7);
    }

    @Test
    public void testSolverHard() {
        int[][] initState = {{0, 3, 5}, {2, 1, 8}, {4, 7, 6}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 12);
    }

    @Test
    public void testSolverReallyHard() {
        int[][] initState = {{3, 5, 6}, {1, 2, 8}, {0, 4, 7}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 16);
    }


    @Test
    public void testSolverRidiculouslyHard() {
        int[][] initState = {{3, 5, 2}, {6, 0, 1}, {7, 8, 4}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 22);
    }

    /**
     * Test method for Solver - Hard puzzle
     * Will take a long time to run
     */
    @Test
    public void testSolverInsane() {
        int[][] initState = {{8, 6, 7}, {2, 5, 4}, {3, 0, 1}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 31);
    }

}
