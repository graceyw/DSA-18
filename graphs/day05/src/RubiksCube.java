import java.awt.*;
import java.security.InvalidKeyException;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


// this is our implementation of a rubiks cube. It is your job to use A* or some other search algorithm to write a
// solve() function
public class RubiksCube implements Comparable<RubiksCube>{

    private BitSet cube;
    ArrayList<Character> moves = new ArrayList<>();
    private float cost;
    //private int movenum;
    //private char lastmove;
    //private RubiksCube lastcube;

    // initialize a solved rubiks cube
    public RubiksCube() {
        // 24 colors to store, each takes 3 bits
        cube = new BitSet(24 * 3);
        for (int side = 0; side < 6; side++) {
            for (int i = 0; i < 4; i++) {
                setColor(side * 4 + i, side);
            }
        }
        cost = findCost();
    }

    // initialize a rubiks cube with the input bitset
    private RubiksCube(BitSet s) {
        cube = (BitSet) s.clone();
    }

    // creates a copy of the rubics cube
    public RubiksCube(RubiksCube r) {
        cube = (BitSet) r.cube.clone();
    }

    // return true if this rubik's cube is equal to the other rubik's cube
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RubiksCube))
            return false;
        RubiksCube other = (RubiksCube) obj;
        return other.cube.equals(cube);
    }

    /**
     * return a hashCode for this rubik's cube.
     *
     * Your hashCode must follow this specification:
     *   if A.equals(B), then A.hashCode() == B.hashCode()
     *
     * Note that this does NOT mean:
     *   if A.hashCode() == B.hashCode(), then A.equals(B)
     */
    @Override
    public int hashCode() {
        return cube.hashCode();
    }

    public boolean isSolved() {
        return this.equals(new RubiksCube());
    }  //works bc new RubiksCubes start out solved


    // takes in 3 bits where bitset.get(0) is the MSB, returns the corresponding int
    private static int bitsetToInt(BitSet s) {
        int i = 0;
        if (s.get(0)) i |= 4;
        if (s.get(1)) i |= 2;
        if (s.get(2)) i |= 1;
        return i;
    }

    // takes in a number 0-5, returns a length-3 bitset, where bitset.get(0) is the MSB
    private static BitSet intToBitset(int i) {
        BitSet s = new BitSet(3);
        if (i % 2 == 1) s.set(2, true);
        i /= 2;
        if (i % 2 == 1) s.set(1, true);
        i /= 2;
        if (i % 2 == 1) s.set(0, true);
        return s;
    }

    // index from 0-23, color from 0-5
    private void setColor(int index, int color) {
        BitSet colorBitset = intToBitset(color);
        for (int i = 0; i < 3; i++)
            cube.set(index * 3 + i, colorBitset.get(i));
    }


    // index from 0-23, returns a number from 0-5
    private int getColor(int index) {
        return bitsetToInt(cube.get(index * 3, (index + 1) * 3));
    }

    // given a list of rotations, return a rubik's cube with the rotations applied
    public RubiksCube rotate(List<Character> c) {
        RubiksCube rub = this;
        for (char r : c) {
            rub = rub.rotate(r);
        }
        return rub;
    }


    // Given a character in ['u', 'U', 'r', 'R', 'f', 'F'], return a new rubik's cube with the rotation applied
    // Do not modify this rubik's cube.
    public RubiksCube rotate(char c) {
        int[] faceFrom = null;
        int[] faceTo = null;
        int[] sidesFrom = null;
        int[] sidesTo = null;
        // colors move from the 'from' variable to the 'to' variable
        switch (c) {
            case 'u': // clockwise
            case 'U': // counterclockwise
                faceFrom = new int[]{0, 1, 2, 3};
                faceTo = new int[]{1, 2, 3, 0};
                sidesFrom = new int[]{4, 5, 8, 9, 17, 16, 21, 20};
                sidesTo = new int[]{21, 20, 4, 5, 8, 9, 17, 16};
                break;
            case 'r':
            case 'R':
                faceFrom = new int[]{8, 9, 10, 11};
                faceTo = new int[]{9, 10, 11, 8};
                sidesFrom = new int[]{6, 5, 2, 1, 17, 18, 13, 14};
                sidesTo = new int[]{2, 1, 17, 18, 13, 14, 6, 5};
                break;
            case 'f':
            case 'F':
                faceFrom = new int[]{4, 5, 6, 7};
                faceTo = new int[]{5, 6, 7, 4};
                sidesFrom = new int[]{3, 2, 8, 11, 14, 15, 23, 20};
                sidesTo = new int[]{8, 11, 14, 15, 23, 20, 3, 2};
                break;
            default:
                System.out.println(c);
                assert false;
        }
        // if performing a counter-clockwise rotation, swap from and to
        if (Character.isUpperCase(c)) {
            int[] temp;
            temp = faceFrom;
            faceFrom = faceTo;
            faceTo = temp;
            temp = sidesFrom;
            sidesFrom = sidesTo;
            sidesTo = temp;
        }
        RubiksCube res = new RubiksCube(cube);
        //res.lastmove = c;
        //res.movenum += movenum; //new ArrayList<>(moves);
        //res.lastcube = this;
        res.moves = new ArrayList<>(moves); // TIMING: THIS ADDS A DECENT AMOUNT OF TIME
        res.moves.add(c);
        //System.out.println(res.moves.size());
        for (int i = 0; i < faceFrom.length; i++) res.setColor(faceTo[i], this.getColor(faceFrom[i]));
        for (int i = 0; i < sidesFrom.length; i++) res.setColor(sidesTo[i], this.getColor(sidesFrom[i]));
        res.cost = res.findCost(); //find the cost now that the cube has been rotated
        return res;
    }

    // returns a random scrambled rubik's cube by applying random rotations
    public static RubiksCube scrambledCube(int numTurns) {
        RubiksCube r = new RubiksCube();
        char[] listTurns = getScramble(numTurns);
        for (int i = 0; i < numTurns; i++) {
            r= r.rotate(listTurns[i]);
        }
        return r;
    }

    public static char[] getScramble(int size){
        char[] listTurns = new char[size];
        for (int i = 0; i < size; i++) {
            switch (ThreadLocalRandom.current().nextInt(0, 6)) {
                case 0:
                    listTurns[i] = 'u';
                    break;
                case 1:
                    listTurns[i] = 'U';
                    break;
                case 2:
                    listTurns[i] = 'r';
                    break;
                case 3:
                    listTurns[i] = 'R';
                    break;
                case 4:
                    listTurns[i] = 'f';
                    break;
                case 5:
                    listTurns[i] = 'F';
                    break;
            }
        }
        return listTurns;
    }

    public Iterable<RubiksCube> neighbors() {
        ArrayList<RubiksCube> cubeNeighbors = new ArrayList<RubiksCube>();
        char[] possibleTurns = {'u', 'U', 'r', 'R', 'f', 'F'};
        for(int i = 0; i<possibleTurns.length;i++){
            cubeNeighbors.add(rotate(possibleTurns[i]));
        }
        return cubeNeighbors;
    }

    public float manhattan(){
        //TODO: Make the dictionary based on BitSet not integers

        // Run for all colors
        int h = 0;
        for (int i = 0; i < 24; i++){
            int color = getColor(i);
            boolean reverse = false;
            if (color > 2){
                color -= 3;
                reverse = true;
            }
            boolean onside = Globals.sideMap.get(color).contains(i);
            boolean val = ((onside || reverse) && ! (onside && reverse)); //returns true if is on correct side, and false if not
            h += val ? 0 : 1; //adds 0 when on correct, adds 1 when not
        }
        return h/4.0f;
    }
    public float ColorManhattan(){

        int h = 0;
        for (int i = 0; i < 24; i++){
            int color = getColor(i);
            int[] loc = Globals.indexLocMap.get(i);
            switch(color){
                case 0:
                    h += (1-loc[2])+1;
                    break;
                case 1:
                    h += (1-loc[0])+1;
                    break;
                case 2:
                    h += (1-loc[1])+1;
                    break;
                case 3:
                    h += loc[2]+1;
                    break;
                case 4:
                    h += loc[0]+1;
                    break;
                case 5:
                    h += loc[1]+1;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return h/8.0f;
    }

    public float FaceCheck(){ //Slower

        int h = 0;
        for (int i = 0; i < 24; i++){
            int color = getColor(i);
            if (color != Math.floor(i/4)) {
                h+=1;
            }
        }
        return h/8.0f;
    }

    

    //public static Comparator<RubiksCube> idComp = new Comparator<RubiksCube>(){

    @Override
    //Runtime: O(1)
    public int compareTo(RubiksCube a) {
        return Float.compare(cost, a.cost);
        /*
        if (a.cost<b.cost){
            return -1;
        } else if (b.cost<a.cost){
            return 1;
        } else {
            return 0;
        }*/
    }

    //};

    //Runtime: O(N) because of manhattan() and numMisplaced()
    public float findCost(){
        int g = this.moves.size();
        float h2 = ColorManhattan();//manhattan();
        //int h1 = this.cube.numMisplaced();
        float f = g+h2; //g+h1+h2;
        return f;
    }

    // return the list of rotations needed to solve a rubik's cube
    public List<Character> solve() { //O(E log (V))
        PriorityQueue<RubiksCube> open = new PriorityQueue<RubiksCube>();
        HashMap<BitSet, Float> openMap = new HashMap<>();
        HashMap<BitSet, Float> closed = new HashMap<BitSet, Float>();

        //boolean ignore;
        moves = new ArrayList<>();
        cost = 0;
        //movenum = 0;
        //lastcube = null;
        //lastmove = Character.MIN_VALUE;

        //RubiksCube currentState = RubiksCube(this);

        open.offer(this);
        openMap.put(cube, cost);

        while (!open.isEmpty()) {
            RubiksCube temp = open.poll();   //highest priority, lowest cost cube
            //openMap.remove(temp);

            for (RubiksCube neigh : temp.neighbors()) {
                //System.out.println(open.size() + " | " + closed.size());

                if (neigh.isSolved()) {
                    //ArrayList<Character> moves = neigh.RebuildMoves(new ArrayList<Character>());
                    System.out.println(neigh.moves);
                    return neigh.moves;
                    //this.minMoves = addState.moves;
                }
                boolean ignore = false;

                if (openMap.containsKey(neigh.cube)){
                //for (RubiksCube currCube: open) {
                    float openCost = openMap.get(neigh.cube);
                    if (openCost <= neigh.cost) {
                        //System.out.println("already here");
                        ignore = true;
                    }
                    /*} else {
                        //System.out.println("Replacing this");
                        open.remove(currCube);
                        open.offer(neigh);
                        ignore = true;
                        break;
                    }*/
                }
                if (!ignore) {
                    //for (RubiksCube visitedCube : closed) {
                    if (closed.containsKey(neigh.cube)){
                        float visitedCubeCost = closed.get(neigh.cube);
                        if (visitedCubeCost <= neigh.cost) {
                            ignore = true;
                        } // TIMING: should there be an else statement?
                    }
                }

                if(!ignore) {
                    open.offer(neigh); // O(log(V))
                    openMap.put(neigh.cube, neigh.cost);
                }
            }
            closed.put(temp.cube, temp.cost);
        }
        return new ArrayList<>();
    }

    /*public ArrayList<Character> RebuildMoves(ArrayList<Character> movelist){
        if (lastmove == Character.MIN_VALUE){
            return movelist;
        }
        movelist = lastcube.RebuildMoves(movelist);
        movelist.add(lastmove);
        return movelist;
    }*/
}
