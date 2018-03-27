import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {

    private static void backtrack(LinkedList<Integer> curr, Set<Integer> unused, List<List<Integer>> subsets) {
        if (unused.isEmpty())
            subsets.add(new LinkedList<>(curr));
        for (int u : new LinkedList<>(unused)) {
            curr.addLast(u);
            unused.remove(u);
            backtrack(curr, unused, subsets);
            unused.add(u);
            curr.removeLast();
        }
    }

    public static List<List<Integer>> permutations(List<Integer> A) {
        // TODO
        List<List<Integer>> permutations = new LinkedList<>();
        return permutations;
    }

}
