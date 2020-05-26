package epi.BinaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateBinaryTree {

    public static BinaryTree<Integer> binaryTreeFromPreorderlnorder(
        List<Integer> preorder, List<Integer> inorder) {
        Map<Integer, Integer> nodeToInorderIdx = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.size(); ++i) {
            nodeToInorderIdx.put(inorder.get(i), i);
        }

        return generateBinaryTreeHelper(preorder, 0, preorder.size(), 0, inorder.size(), nodeToInorderIdx);
    }

    private static BinaryTree<Integer> generateBinaryTreeHelper(
            List<Integer> preorder, int pstart, int pend,
            int istart, int iend, Map<Integer, Integer> nodeToInorderIdx) {
        if (pend <= pstart || iend <= istart) {
            return null;
        }
        int rootIdx = nodeToInorderIdx.get(preorder.get(pstart));
        int leftSubtree = rootIdx - istart;

        return new BinaryTree<>(preorder.get(pstart),
                generateBinaryTreeHelper(preorder, pstart+1, pstart + 1 + leftSubtree,
                        istart, rootIdx, nodeToInorderIdx),
                generateBinaryTreeHelper(preorder, pstart+1+leftSubtree, pend,
                        rootIdx+1, iend, nodeToInorderIdx));
    }

    public static void main(String argsp[]) {
        BinaryTree<Integer> result = binaryTreeFromPreorderlnorder(Arrays.asList(3,9,20,15,7),
                Arrays.asList(9,3,15,20,7));
        result.printInOrder(result);
        result.printPostOrder(result);
        result.printPreOrder(result);
    }
}
