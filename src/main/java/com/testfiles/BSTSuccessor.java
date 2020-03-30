package com.testfiles;


public class BSTSuccessor {

    /// I will learn from my mistakes - I have made really stupid mistakes because of not coverign all the
    // basic fucking usecases - please please please I apologize
    static TreeNode node5 = new TreeNode(5, null, null);;
    static TreeNode node10 = new TreeNode(10, null, null);
    static TreeNode node13 = new TreeNode(13, null, null);
    static TreeNode node11 = new TreeNode(11, null, null);
    static TreeNode node4 = new TreeNode(4, null, null);
    static TreeNode node3 = new TreeNode(3, null, null);
    static TreeNode node1 = new TreeNode(1, null, null);
    public static void main(String args[]) {
        node5.left = node3;
        node5.right = node13;
        node3.left = node1;
        node3.right = node4;
        node13.left = node11;
        node11.left = node10;
        TreeNode node = node5;
//        System.out.printf("Next successor of the node %d is %d" ,
//                13, findSuccessorOfTheNode(node, 13).val);
        System.out.printf("Next successor of the node %d is %d \n" ,
                11, findSuccessorOfTheNode(node, 11).val);
        System.out.printf("Next successor of the node %d is %d \n" ,
                10, findSuccessorOfTheNode(node, 10).val);
        System.out.printf("Next successor of the node %d is %d \n" ,
                5, findSuccessorOfTheNode(node, 5).val);
        System.out.printf("Next successor of the node %d is %d \n" ,
                4, findSuccessorOfTheNode(node, 4).val);
        System.out.printf("Next successor of the node %d is %d \n" ,
                3, findSuccessorOfTheNode(node, 3).val);
        System.out.printf("Next successor of the node %d is %d \n" ,
                1, findSuccessorOfTheNode(node, 1).val);
    }

    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int i, TreeNode o, TreeNode o1) {
            val = i;
            left = o;
            right = o1;
        }
    }
    public static TreeNode findSuccessorOfTheNode(TreeNode node, int key) {
        TreeNode firstSuccessor = null;
        while(node != null) {
            if (node.val > key) {
                //find in left subtree
                firstSuccessor = node;
                node = node.left;
            } else {
                node = node.right;
            };
        }
        return firstSuccessor;
    }

    // Time complexity = o(h) - height of the tree
    // Space complexity = o(1)
}
