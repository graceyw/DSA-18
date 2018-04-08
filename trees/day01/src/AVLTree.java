public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    /**
     * Delete a key from the tree rooted at the given node.
     */
    @Override
    TreeNode<T> delete(TreeNode<T> n, T key) {
        n = super.delete(n, key);
        if (n != null) {
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));       // update the height of the tree using the height of the left and right child
            return balance(n);
        }
        return null;
    }

    /**
     * Insert a key into the tree rooted at the given node.
     */
    @Override   //Means I have to call super.insert in order to access the insert function in BST.java
    
    //Runtime: O(logN)? ("How many times can I divide by 2 until I get to 1, i.e. the root?)
    //logN is also therefore the height of a perfectly balanced binary search tree i.e. whole bottom row is completely filled
    TreeNode<T> insert(TreeNode<T> n, T key) {
        n = super.insert(n, key);
        if (n != null) {
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));       // update the height of the tree using the height of the left and right child
            return balance(n);
        }
        return null;
    }

    /**
     * Delete the minimum descendant of the given node.
     */
    @Override

    //Runtime: O(logN) because it's logN to find the node and logN to re-balance
    TreeNode<T> deleteMin(TreeNode<T> n) {
        n = super.deleteMin(n);
        if (n != null) {
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    // Return the height of the given node. Return -1 if null.
    private int height(TreeNode<T> n) {
        if (n == null) return -1;
        return (Math.max(height(n.leftChild), height(n.rightChild))+1);
    }

    public int height() {
        return Math.max(height(root), 0);
    }

    // Restores the AVL tree property of the subtree. Return the head of the new subtree
    TreeNode<T> balance(TreeNode<T> n) {
        if (balanceFactor(n) > 1) {                             //if very right-heavy
            if (balanceFactor(n.rightChild) < 0) {              //if rightChild is left-heavy
                n.rightChild = rotateRight(n.rightChild);
            }
            n = rotateLeft(n);
        }
        else if (balanceFactor(n) < -1) {                       //if very left-heavy
            if (balanceFactor(n.rightChild) > 0) {              //if leftChild is right-heavy
                n.leftChild = rotateLeft(n.leftChild);
            }
            n = rotateRight(n);
        }
        return n;
    }

    /**
     * Returns the balance factor of the subtree. The balance factor is defined
     * as the difference in height of the left subtree and right subtree, in
     * this order. Therefore, a subtree with a balance factor of -1, 0 or 1 has
     * the AVL property since the heights of the two child subtrees differ by at
     * most one.
     */
    private int balanceFactor(TreeNode<T> n) {
        return (height(n.rightChild) - height(n.leftChild));
    }

    /**
     * Perform a right rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateRight(TreeNode<T> n) {
        TreeNode x = n.leftChild;
        n.leftChild = x.rightChild;
        x.rightChild = n;
        n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));       // update the height of the tree using the height of the left and right child
        x.height = 1 + Math.max(height(x.leftChild), height(x.rightChild));       // update the height of the tree using the height of the left and right child
        return x;
    }

    /**
     * Perform a left rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateLeft(TreeNode<T> n) {
        TreeNode x = n.rightChild;
        n.rightChild = x.leftChild;
        x.leftChild = n;
        n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));       // update the height of the tree using the height of the left and right child
        x.height = 1 + Math.max(height(x.leftChild), height(x.rightChild));       // update the height of the tree using the height of the left and right child
        return x;
    }
}