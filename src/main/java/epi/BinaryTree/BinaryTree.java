package epi.BinaryTree;

public class BinaryTree<T> {
    public T val;
    public BinaryTree<T> left, right, parent;

    public BinaryTree(T val, BinaryTree<T> left, BinaryTree<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void printInOrder(BinaryTree<T> result) {
        if (result == null) {
            return;
        }
        printInOrder(result.left);
        System.out.print(result.val + ",");
        printInOrder(result.right);
    }

    public void printPreOrder(BinaryTree<T> result) {
        if (result == null) {
            return;
        }
        System.out.print(result.val + ",");
        printPreOrder(result.left);
        printPreOrder(result.right);
    }

    public void printPostOrder(BinaryTree<T> result) {
        if (result == null) {
            return;
        }
        printPostOrder(result.left);
        printPostOrder(result.right);
        System.out.print(result.val + ",");
    }
}
