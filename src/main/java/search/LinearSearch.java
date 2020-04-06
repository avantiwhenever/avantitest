package search;

import java.util.Arrays;

public class LinearSearch {

    public static void main(String args[]) {
        int[][] testcases = { { 3, 2, -2, 5, -3 }, { 1, 2, 3, -4 }, { 1, 1, 1 } };
        for (int[] testcase : testcases)
            printResult(testcase, (testcase.length > 0) ? testcase[testcase.length-1] : 0);
    }

    private static void printResult(int[] nums, int n) {
        System.out.println(Arrays.toString(nums) + " finding element  = " + n);
        int index = linerSearch(nums, n);
        System.out.println(index == -1 ? "Number not found" : "Number found at location : " + index);
    }

    private static int linerSearch(int[] nums, int n) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
