/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to find a path to the goal
 */

import java.util.*;

public class Solver {

    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;

    /**
     * State class to make the cost calculations simple
     * This class holds a board state and all of its attributes
     */
    private class State {
        // Each state needs to keep track of its cost and the previous state
        private Board board;
        private int moves;                       // equal to g-cost in A*
        public int cost;                         // equal to f-cost in A*
        private State prev;

        public State(Board board, int moves, State prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            cost = findCost();
        }

        /*
         * Finds the cost of a state
         */
        public int findCost(){
            int g = this.moves;
            int h2 = this.board.manhattan();
            int h1 = this.board.numMisplaced();
            int f = g+h1+h2;
            return f;
        }

        @Override
        public boolean equals(Object s) {
            if (s == this) return true;
            if (s == null) return false;
            if (!(s instanceof State)) return false;
            return ((State) s).board.equals(this.board);
        }
    }

    /*
     * Return the root state of a given state
     */
    private State root(State state) {
        return state.prev;
    }


    /*
     * A* Solver
     * Find a solution to the initial board using A* to generate the state tree
     * and a identify the shortest path to the the goal state
     */
    public Solver(Board initial) {
        // TODO: Your code here
        State start = new State(initial, 0, null);
        ArrayList<State> open = new ArrayList<>();
        ArrayList<State> closed = new ArrayList<>();
        open.add(start);

        State closestState = start;
        while (!open.isEmpty()) {
            int smallestCost = 100000000;
            for (State s : open) {
                if (s.cost < smallestCost) {
                    smallestCost = s.cost;
                    closestState = s;              //q in the pseudocode
                }
            }
            Iterable<Board> neighbors = closestState.board.neighbors();
            for (Board neighBoard : neighbors) {
                State neighState = new State(neighBoard, closestState.moves+1,closestState);
                if (neighState.board.equals(solutionState.board)) return;    //stop search because this is the solution

            }
        }
    }

    /*
     * Is the input board a solvable state?
     * Research how to check this without exploring all states
     */
    public boolean isSolvable(Board initial) {
        return initial.solvable();
    }

    /*
     * Return the sequence of boards in a shortest solution, null if unsolvable
     */
    public Iterable<Board> solution(State solved, State initial) {
        if (!this.isSolvable(initial.board)){
            return null;
        }
        LinkedList<Board> finalSolution = new LinkedList<>();
        State current = solved;
        while (current.moves != 0){
            finalSolution.addFirst(current.board);
            current = current.prev;
        }
        return finalSolution;
    }

    public State find(Iterable<State> iter, Board b) {
        for (State s : iter) {
            if (s.board.equals(b)) {
                return s;
            }
        }
        return null;
    }

    /*
     * Debugging space
     */
    public static void main(String[] args) {
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board initial = new Board(initState);

        Solver solver = new Solver(initial);
    }

}
