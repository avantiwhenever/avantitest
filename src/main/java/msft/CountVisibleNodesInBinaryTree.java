package msft;

import java.util.Arrays;

/*
 * https://leetcode.com/discuss/interview-question/546703/
 * In a binary tree, if in the path from root to the node A, there is no node with
 * greater value than A’s, this node A is visible.
 * We need to count the number of visible nodes in a binary tree.
 *
 *Input:
        5
     /     \
   3        10
  /  \     /
20   21   1

Output: 4
Explanation: There are 4 visible nodes: 5, 20, 21, and 10.

  -10
	\
	-15
	   \
	   -1

Time: O(n)
Space: O(n)
*/
public class CountVisibleNodesInBinaryTree {

    public static void main(String[] args) {
		/*
		 *          5
		 *         / \
			     /     \
			   3        10
			  /  \     /
			20   21   1
		 */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(21);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(1);

        printResult(new int[] {20,3,21,5,1,10},root);

        /*
         *      5
         *     /
         *    3
         *   / \
         * 20  21
         *
         */
        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(21);
        printResult(new int[]{20, 21, 3, 5}, root);

        /*
         *      5
         *       \
         *    	  3
         *       / \
         *     20  21
         *
         */
        root = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(20);
        root.right.right = new TreeNode(21);
        printResult(new int[]{5, 20, 13, 21}, root);

		/*
		 *   -10
				\
				-15
				   \
				   -1
		 */
        root = new TreeNode(-10);
        root.right = new TreeNode(-15);
        root.right.right = new TreeNode(-1);
        printResult(new int[]{-10, -15, -1}, root);

		/*
		 *    10
				\
				 15
				   \
				    1
		 */
        root = new TreeNode(10);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(1);
        printResult(new int[]{10, 15, 1}, root);

        /*
         * 	0
         */
        root = new TreeNode(0);
        printResult(new int[]{0}, root);

        /*
         *   1
         *  / \
         * 1   1
         */
        root = new TreeNode(1);
        root.left= new TreeNode(1);
        root.right= new TreeNode(1);
        printResult(new int[]{1, 1, 1}, root);
    }

    public static int countVisibleNodes(TreeNode root) {
        return countVisibleNodes(root, Integer.MIN_VALUE);
    }

    private static int countVisibleNodes(TreeNode node, int maxSoFar) {
        if (node == null)
            return 0;

        int count = 0;

        if (node.val >= maxSoFar) {
            count = 1;
            maxSoFar = node.val;
        }

        return count + countVisibleNodes(node.left, maxSoFar) + countVisibleNodes(node.right, maxSoFar);
    }

    private static void printResult(int[] ints, TreeNode root) {
        System.out.println(Arrays.toString(ints) + "  = Visible nodes - " + countVisibleNodes(root));
    }
}