package search;

import java.util.Arrays;

public class BinarySearch {
    /*
    https://www.geeksforgeeks.org/binary-search/
     */
    public static void main(String args[]) {
        int[][] testcases = { { 3, 2, -2, 5, -3 }, { 1, 2, 3, -4 }, { 1, 1, 1 } };
        for (int[] testcase : testcases)
            printResult(testcase, (testcase.length > 0) ? testcase[testcase.length-1] : 0);
    }

    private static void printResult(int[] nums, int n) {
        System.out.println(Arrays.toString(nums) + " finding element  = " + n);
        int index = binarySearch(nums, n);
        System.out.println(index == -1 ? "Number not found" : "Number found at location : " + index);
        int index2 = binarySearchRecursive(nums, n, 0, nums.length);
        System.out.print("Recursive : ");
        System.out.println(index2 == -1 ? "Number not found" : "Number found at location : " + index2);
    }

    private static int binarySearch(int[] nums, int key) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = (start) + (end - start)/2;
            if (nums[mid] == key) {
                return mid;
            }
            if (nums[mid] < key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] nums, int key, int start, int end) {
        if (start < end) {
            int mid = (start) + (end - start)/2;
            if (nums[mid] == key) {
                return mid;
            }
            if (nums[mid] < key) {
                return binarySearchRecursive(nums, key, start, mid - 1);
            } else {
                return binarySearchRecursive(nums, key, mid + 1, end);
            }
        }
        return -1;
    }
}
