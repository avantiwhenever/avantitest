package msft;

/*

https://leetcode.com/discuss/interview-question/406031/

Write a function that, given an array A of N integers, returns the lagest integer K > 0 such that both values K and -K exisit in array A. If there is no such integer, the function should return 0.

Example 1:

Input: [3, 2, -2, 5, -3]
Output: 3
Example 2:

Input: [1, 2, 3, -4]
Output: 0
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestInteger {

    public static void main(String[] args) {
        int[][] testcases = { { 3, 2, -2, 5, -3 }, { 1, 2, 3, -4 }, { 1, 1, 1 } };
        for (int[] testcase : testcases)
            printResult(testcase);
    }

    private static void printResult(int[] piles) {
        System.out.println(Arrays.toString(piles) + " MinSteps = " + largestNum(piles));
    }

    private static int largestNum(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(-num);
            if (set.contains(num)) {
                res = Math.max(res, Math.abs(num));
            }
        }
        return res;
    }
}
