import java.util.*;

public class Cryptarithmetic {

    // Do not modify this function (though feel free to use it)
    public static boolean validSolution(String S1, String S2, String S3, Map<Character, Integer> assignments) {
        return (stringToInt(S1, assignments) + stringToInt(S2, assignments) == stringToInt(S3, assignments))
                && assignments.get(S1.charAt(0)) != 0
                && assignments.get(S2.charAt(0)) != 0
                && assignments.get(S3.charAt(0)) != 0;
    }


    private static Iterable<Integer> randomOrder() {
        List<Integer> l = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(l);
        return l;
    }

    private static int stringToInt(String s, Map<Character, Integer> assignments) {
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            i *= 10;
            i += assignments.get(s.charAt(j));
        }
        return i;
    }

    private static boolean recurse(String S1, String S2, String S3, Map<Character, Integer> assignments, List<Character> unassigned) {
        if (unassigned.isEmpty()) {
            validSolution(S1, S2, S3, assignments);
        }
        for (int i=0; i<=9; i++) {
            char c = unassigned.remove(0);
            assignments.put(c,i);
            if (recurse(S1, S2, S3, assignments, unassigned)) {
                return true;
            }
            assignments.remove(c);
            unassigned.add(c);
        }
        return false;        //if no combinations work
    }

    public static Map<Character, Integer> solvePuzzle(String S1, String S2, String S3) {
        Map<Character, Integer> assignments = new HashMap<>();
        List<Character> unassigned = new LinkedList<>();
        for (char c : (S1 + S2 + S3).toCharArray()) {          //makes an array of all 3 strings together
            if (!unassigned.contains(c)) {                     //if c hasn't already been added
                unassigned.add(c);
            }
        }
        recurse(S1, S2, S3, assignments, unassigned);
        return assignments;
    }
}