package sort;

import java.util.Arrays;

public class SelectionSort {
    /*
    https://www.tutorialspoint.com/data_structures_algorithms/selection_sort_algorithm.htm
     */
    public static void main(String args[]) {
        int[][] testcases = { { 3, 2, -2, 5, -3 }, { 1, 2, 3, -4 }, { 1, 1, 1 } };
        for (int[] testcase : testcases)
            printResult(testcase);
    }

    private static void printResult(int[] piles) {
        System.out.println(Arrays.toString(piles) + " selectionSort = ");
        selectionSort(piles);
        System.out.println(Arrays.toString(piles));
    }

    private static void selectionSort(int[] nums){
        for (int i=0; i<nums.length; i++) {
            int min = i;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(nums, i, min);
            }
        }
    }

    private static void swap(int [] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

}
