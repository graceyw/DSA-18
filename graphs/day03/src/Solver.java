/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to find a path to the goal
 */

import java.sql.SQLOutput;
import java.util.*;
import java.util.Comparator;


public class Solver {

    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;
    private State start;

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
        //Runtime: O(N) because of manhattan() and numMisplaced()
        public int findCost(){
            int g = this.moves;
            int h2 = this.board.manhattan();
            int h1 = this.board.numMisplaced();
            int f = g+h1+h2;
            return f;
        }

        @Override

        //Runtime: O(N)
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
    //Runtime: O(1)
    private State root(State state) {
        return state.prev;
    }

    public static Comparator<State> idComp = new Comparator<State>(){

        @Override
        //Runtime: O(1)
        public int compare(State a, State b) {
            if (a.cost<b.cost){
                return -1;
            } else if (b.cost<a.cost){
                return 1;
            } else {
                return 0;
            }
        }

    };

    /*
     * A* Solver
     * Find a solution to the initial board using A* to generate the state tree
     * and a identify the shortest path to the the goal state
     */

    // Cohesive Runtime: O(N^2 * e/v) where:
    // N is the # of states (open or closed)
    // e is the total # of connections in the graph (related to # of neighbors)
    // v is the total # of states in the graph 
    public Solver(Board initial) {

        Board goalBoard = new Board(initial.goal);
        solutionState = new State(goalBoard, 0, null);
        start = new State(initial, 0, null);

        if (!this.isSolvable()){
            return;
        }

        PriorityQueue<State> openQueue = new PriorityQueue<>(idComp);
        ArrayList<State> closed = new ArrayList<>();
        openQueue.add(start);

        State closestState = start;
        while (!openQueue.isEmpty()) {                                            //O(N)

            closestState = openQueue.poll();                                      //O(logN)

            Iterable<Board> neighbors = closestState.board.neighbors();
            for (Board neighBoard : neighbors) {                                  //O(e/v). Also side note: there are 4 neighbors max with this implementation
                State neighState = new State(neighBoard, closestState.moves+1,closestState);

                if (neighState != null && neighState.board.equals(solutionState.board)) {
                    solutionState.moves = closestState.moves+1;
                    this.minMoves = solutionState.moves;
                    solutionState.prev=closestState;
//                    solution(solutionState);                  //prints steps to find solution
                    return;                                     //stop search because this is the solution
                }

                boolean ignore = false;
                for (State openState: openQueue){                                  //O(N)
                    if (openState.board.equals(neighState.board)){
                        ignore = true;
                        if (neighState.cost<openState.cost) {
                            openState.cost = neighState.cost;
                            openState.moves = neighState.moves;
                            openState.prev = closestState;
                        }
                    }
                }
                for (State closedState: closed){                                   //O(N)
                    if (closedState.board.equals(neighState.board)){
                        ignore = true;
                        if (neighState.cost<closedState.cost) {
                            closedState.cost = neighState.cost;
                            closedState.moves = neighState.moves;
                            closedState.prev = closestState;
                        }
                    }
                }

                if (ignore == false){
                    neighState.prev = closestState;
                    openQueue.add(neighState);
                }
            }
            closed.add(closestState);
        }
    }

    /*
     * Is the input board a solvable state?
     * Research how to check this without exploring all states
     */
    //Runtime: O(N^2) because of solvable() (which is because of getInvCount())
    public boolean isSolvable() {
        return start.board.solvable();
    }

    /*
     * Return the sequence of boards in a shortest solution, null if unsolvable
     */
    //Runtime: O(N) with N being minMoves
    public Iterable<Board> solution(State solved) {
        if (!this.isSolvable()){
            return null;
        }
        LinkedList<Board> finalSolution = new LinkedList<>();
        State current = solved;
        while (current.moves != 0){
            current.board.displayBoard();
            finalSolution.addFirst(current.board);
            current = current.prev;
        }
        return finalSolution;
    }

    //Don't really use this function because we wrote our own in solver where we edit some #s of moves in closed
    //Runtime: O(N * elems in b)
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
