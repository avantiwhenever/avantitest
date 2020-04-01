package msft;
/*
https://leetcode.com/discuss/interview-question/428272/

https://leetcode.com/problems/arithmetic-slices/
 */

import java.util.Arrays;

public class ParticleVelocity {

    public static void main(String[] args) {
        printResult(new int[] {1, 3, 5, 7, 9});
        printResult(new int[] {7, 7, 7, 7});
        printResult(new int[] {3, -1, -5, -9});
        printResult(new int[] {1, 1, 2, 5, 7});
        printResult(new int[] {1, 2, 3, 4});
    }

    private static void printResult (int[] str) {
        System.out.println("Printing numberOfArithmeticSlices of string input : "
                + Arrays.toString(str) + " =" + numberOfArithmeticSlices(str));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
}
