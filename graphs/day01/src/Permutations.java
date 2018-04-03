import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {

    // Runtime: N*N! (because there are N! potential perms and it took N to get each perm)
    // Space: N*p
    private static void namePermutations(LinkedList<Integer> curr, Set<Integer> un, List<List<Integer>> perms) {
        if (un.isEmpty()) {                                 //if all integers have been added
            perms.add(new LinkedList<>(curr));              //add perm to permutations
        }
        for (int c : new LinkedList<>(un)) {
            curr.addLast(c);
            un.remove(c);
            namePermutations(curr, un, perms);
            un.add(c);
            curr.removeLast();
        }
    }

    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> permutations = new LinkedList<>();
        Set<Integer> unused = new HashSet<>(A);                //sets don't do duplicates so this func doesn't find the perms of an input w/ duplicates, but it is faster than a list
        namePermutations(new LinkedList<Integer>(), unused, permutations);
        return permutations;
    }
}