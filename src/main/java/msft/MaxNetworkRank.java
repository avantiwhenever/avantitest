package msft;

import java.util.Arrays;
/*

https://leetcode.com/discuss/interview-question/364760/
It's not clear what is the eactly the network rank.
Is network rank will be there of each edge. That means it will have m network rank
and we have to find the pair of cities(edge) which have the highest network rank.
 If this is the case just use a data structure like an array to store the
  count of other nodes connected to a node.
  Then just iterate on the edges and see if count of cities
  on the this edge's end is max or not.
 */
public class MaxNetworkRank {

    public static void main(String[] args) {
        printResult(new int[] {1, 2, 3, 3}, new int[] {2, 3, 1, 4}, 4);
        printResult(new int[] {1, 2, 2, 3}, new int[] {2, 3, 1, 4}, 4);
        printResult(new int[] {1, 2, 3, 3}, new int[] {2, 3, 1, 4}, 4);

    }

    private static void printResult (int[] nums1,int[] nums2, int length) {
        System.out.println("Printing getMaxNetworkRank of two digits "
                + Arrays.toString(nums1) + " " + Arrays.toString(nums2) + " " + length +
                " =" + getMaxNetworkRank(nums1, nums2, length));
    }

    private static int getMaxNetworkRank(int[] A, int[] B, int N) {
        int maxRank = 0;
        int edgesLen = A.length;

        int[] edgesCount = new int[N + 1];

        for(int i=0; i<edgesLen; i++){
            edgesCount[A[i]] += 1;
            edgesCount[B[i]] += 1;
        }

        for(int i=0; i<edgesLen; i++){
            int localMax = edgesCount[A[i]] + edgesCount[B[i]] - 1;
            maxRank = Math.max(maxRank, localMax);
        }

        return maxRank;
    }
}
