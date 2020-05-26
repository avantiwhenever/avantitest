package epi.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FormLLFromBTreeLeaves {

    //FORM A LINKED LIST FROM THE LEAVES OF A BINARY TREE

    public static void main(String a[]) {

        BinaryTree<Integer> result = GenerateBinaryTree.binaryTreeFromPreorderlnorder(Arrays.asList(3, 9, 20, 15, 7),
                Arrays.asList(9, 3, 15, 20, 7));

        List<BinaryTree<Integer>> res = createLLFromBTreeLeaves(result);

        printResult(res);

    }

    private static void printResult(List<BinaryTree<Integer>> res) {
        for (int i=0; i<res.size(); i++) {
            System.out.print(res.get(i).val + ", ");
        }
    }

    public static List<BinaryTree<Integer>> createLLFromBTreeLeaves(BinaryTree<Integer> root) {

        List<BinaryTree<Integer>> result = new LinkedList<>();
        generateLLFromBtree(root, result);
        return result;
    }

    private static void generateLLFromBtree(BinaryTree<Integer> root,
                                            List<BinaryTree<Integer>> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(root);
            return;
        }
        generateLLFromBtree(root.left, result);
        generateLLFromBtree(root.right, result);
    }
}
