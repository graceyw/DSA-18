import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        // TODO
        return new BinarySearchTree<>();
    }

    //Runtime if no duplicates: O(N)
    //Runtime if duplicates: O(logN*2^something) madness/weirdness
    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1.key != n2.key) return false;           //if roots are different

        if (isIsomorphic(n1.leftChild, n2. leftChild) && isIsomorphic(n1.rightChild, n2.rightChild)) {
            return true;
        }
        if (isIsomorphic(n1.leftChild, n2. rightChild) && isIsomorphic(n1.rightChild, n2.leftChild)) {
            return true;
        }
        return false;        //will return false if one branch of children is true and one is false
    }
}