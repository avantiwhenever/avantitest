package sort;

import java.util.Arrays;

public class BubbleSort {
    /*
    https://www.tutorialspoint.com/data_structures_algorithms/bubble_sort_algorithm.htm
     */
    public static void main(String args[]) {
        int[][] testcases = { { 3, 2, -2, 5, -3 }, { 1, 2, 3, -4 }, { 1, 1, 1 } };
        for (int[] testcase : testcases)
            printResult(testcase);
    }

    private static void printResult(int[] piles) {
        System.out.println(Arrays.toString(piles) + " bubbleSort = ");
        bubbleSort(piles);
        System.out.println(Arrays.toString(piles));
    }

    private static void bubbleSort(int[] nums){
        for (int i=0; i<nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void swap(int [] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
