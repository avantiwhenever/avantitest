package epi.BinaryTree;

public class LcaWithParentNode {

    public static BinaryTree<Integer> LCA (BinaryTree <Integer > node0,
                                           BinaryTree <Integer > node1) {
        int depth0 = getDepth(node0);
        int depth1 = getDepth(node1);
        if (depth1 > depth0) {
            BinaryTree<Integer> temp = node0;
            node0 = node1;
            node1 = temp;
        }
        int diffDepth = Math.abs(depth0 - depth1);
        while (diffDepth-- > 0) {
            node0 = node0.parent;
        }
        while (node0 != node1) {
            node0 = node0.parent;
            node1 = node1.parent;
        }
        return node0;
    }

    private static int getDepth(BinaryTree<Integer> node0) {
        int depth = 0;
        while(node0 != null) {
            depth++;
            node0 = node0.parent;
        }
        return depth;
    }

}

