package msft;

import java.util.Arrays;

public class MaxNetworkRank {

    public static void main(String[] args) {
        printResult(new int[] {1, 2, 3, 3}, new int[] {2, 3, 1, 4}, 4);
        printResult(new int[] {1, 2, 2, 3}, new int[] {2, 3, 1, 4}, 4);
        printResult(new int[] {1, 2, 3, 3}, new int[] {2, 3, 1, 4}, 4);

    }

    private static void printResult (int[] nums1,int[] nums2, int length) {
        System.out.println("Printing maxSumOfTwoDigits of two digits "
                + Arrays.toString(nums1) + " " + Arrays.toString(nums2) + " " + length +
                " =" + solution(nums1, nums2, length));
    }

    public static int solution(int[] A, int[] B, int N) {
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
