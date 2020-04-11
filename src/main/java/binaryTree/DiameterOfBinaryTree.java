package binaryTree;

import msft.TreeNode;

import java.util.Arrays;
import java.util.List;

public class DiameterOfBinaryTree {

    public static void main(String[] args)
    {
        TreeNode treeNode = new TreeNode(10);
        List<TreeNode> testCases = Arrays.asList(treeNode.buildTreeOne(),
                treeNode.buildTreeTwo(),
                treeNode.buildTreeThree(),
                treeNode.buildTreeFour(),
                treeNode.buildTreeFive(),
                treeNode.buildTreeSix(),
                treeNode.buildTreeSeven());
        for (TreeNode node : testCases) {
            printResult(node);
        }
    }

    private static void printResult (TreeNode num) {
        System.out.println("Printing diameterOfBinaryTree of node = " + diameterOfBinaryTree(num));
    }

    static int ans;
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans-1;
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = depth(root.left);
        int maxRight = depth(root.right);
        ans = Math.max(ans, (maxLeft + maxRight + 1));
        return Math.max(maxLeft, maxRight) + 1;
    }
}
