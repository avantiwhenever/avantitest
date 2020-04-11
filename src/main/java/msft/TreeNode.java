package msft;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public TreeNode buildTreeOne() {
        /*
		             5
		           /   \
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
        return root;
    }

    public TreeNode buildTreeTwo() {
        /*
         *      5
         *     /
         *    3
         *   / \
         * 20  21
         *
         */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(21);
        return root;
    }

    public TreeNode buildTreeThree() {
        /*
         *      5
         *       \
         *    	  3
         *       / \
         *     20  21
         *
         */
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(20);
        root.right.right = new TreeNode(21);
        return root;
    }

    public TreeNode buildTreeFour() {
		/*
		 *   -10
				\
				-15
				   \
				   -1
		 */
        TreeNode root = new TreeNode(-10);
        root.right = new TreeNode(-15);
        root.right.right = new TreeNode(-1);
        return root;
    }

    public TreeNode buildTreeFive() {
        		/*
		 *    10
				\
				 15
				   \
				    1
		 */
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(1);
        return root;
    }

    public TreeNode buildTreeSix() {
        return new TreeNode(0);
    }

    public TreeNode buildTreeSeven() {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(1);
        root.right= new TreeNode(1);
        return root;
    }
}